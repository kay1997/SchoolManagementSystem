package com.controller.admin;

import com.domain.admin.School;
import com.service.admin.impl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.SchoolService;

import java.util.Set;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolServiceImpl service;

    @PostMapping("/create")
    public School create(@RequestBody School school) {
        return service.create(school);
    }

    @PostMapping("/update")
    public School update(@RequestBody School school) {
        return service.update(school);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public School read(@PathVariable String id) {

        School school = service.read(id);
        return school;
    }

    @GetMapping("/getall")
    public Set<School> getAll(){
        return service.getAll();
    }
}