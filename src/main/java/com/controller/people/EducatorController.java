package com.controller.people;

import com.domain.people.Educator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.EducatorService;

@RestController
@RequestMapping("/educator")
public class EducatorController {

    @Autowired
    @Qualifier("ServiceImpl")
    private EducatorService service;

    @PostMapping("/create")
    @ResponseBody
    public Educator create(Educator educator) {
        return service.create(educator);
    }

    @PostMapping("/update")
    @ResponseBody
    public Educator update(Educator educator) {
        return service.update(educator);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Educator read(@PathVariable String id) {
        return service.read(id);
    }

}