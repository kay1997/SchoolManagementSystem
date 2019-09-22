package com.controller.assessments;

import com.domain.assessments.Test;
import com.service.assessments.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.assessments.TestService;

import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestServiceImpl service;

    @PostMapping("/create")
    public Test create(@RequestBody Test test) {
        return service.create(test);
    }

    @PostMapping("/update")
    public Test update(@RequestBody Test test) {
        return service.update(test);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Test read(@PathVariable String id) {

        Test test = service.read(id);
        return test;
    }

    @GetMapping("/getall")
    public Set<Test> getAll(){
        return service.getAll();
    }


}