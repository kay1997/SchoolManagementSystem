package com.controller.admin;

import com.domain.admin.Subject;
import com.service.admin.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.SubjectService;

import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectServiceImpl service;

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject) {
        return service.create(subject);
    }

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject) {
        return service.update(subject);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Subject read(@PathVariable String id) {

        Subject subject = service.read(id);
        return subject;
    }

    @GetMapping("/getall")
    public Set<Subject> getAll(){
        return service.getAll();
    }
}