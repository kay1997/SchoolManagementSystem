package com.controller.assessments;

import com.domain.assessments.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.assessments.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    @Qualifier("ServiceImpl")
    private AssignmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Assignment create(Assignment assignment) {
        return service.create(assignment);
    }

    @PostMapping("/update")
    @ResponseBody
    public Assignment update(Assignment assignment) {
        return service.update(assignment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Assignment read(@PathVariable String id) {
        return service.read(id);
    }

}