package com.controller.admin;

import com.domain.admin.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    @Qualifier("ServiceImpl")
    private SubjectService service;

    @PostMapping("/create")
    @ResponseBody
    public Subject create(Subject subject) {
        return service.create(subject);
    }

    @PostMapping("/update")
    @ResponseBody
    public Subject update(Subject subject) {
        return service.update(subject);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Subject read(@PathVariable String id) {
        return service.read(id);
    }

}