package com.controller.assessments;

import com.domain.assessments.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.assessments.TestService;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    @Qualifier("ServiceImpl")
    private TestService service;

    @PostMapping("/create")
    @ResponseBody
    public Test create(Test test) {
        return service.create(test);
    }

    @PostMapping("/update")
    @ResponseBody
    public Test update(Test test) {
        return service.update(test);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Test read(@PathVariable String id) {
        return service.read(id);
    }

}