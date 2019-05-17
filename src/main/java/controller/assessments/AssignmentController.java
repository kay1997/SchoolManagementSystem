package controller.assessments;

import domain.assessments.Assignment;
import factory.assessments.AssignmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.assessments.impl.AssignmentServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentServiceImpl service;

    @GetMapping("/create/{assignment}")
    public @ResponseBody
    Assignment create(@PathVariable String assignmentNumber, String assignmentType)
    {
        Assignment assignment = AssignmentFactory.getAssignment(assignmentNumber, assignmentType);
        return service.create(assignment);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Assignment> getAll() {
        return service.getAll();
    }
}
