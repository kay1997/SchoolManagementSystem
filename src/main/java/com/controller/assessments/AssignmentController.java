package com.controller.assessments;

import com.domain.assessments.Assignment;
import com.service.assessments.impl.AssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.assessments.AssignmentService;

import java.util.Set;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentServiceImpl service;

    @PostMapping("/create")
    public Assignment create(@RequestBody Assignment assignment) {
        return service.create(assignment);
    }

    @PostMapping("/update")
    public Assignment update(@RequestBody Assignment assignment) {
        return service.update(assignment);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Assignment read(@PathVariable String id) {

        Assignment assignment = service.read(id);
        return assignment;
    }

    @GetMapping("/getall")
    public Set<Assignment> getAll(){
        return service.getAll();
    }

}