package com.controller.people;

import com.domain.people.Educator;
import com.service.people.impl.EducatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.EducatorService;

import java.util.Set;

@RestController
@RequestMapping("/educator")
public class EducatorController {

    @Autowired
    private EducatorServiceImpl service;

    @PostMapping("/create")
    public Educator create(@RequestBody Educator educator) {
        return service.create(educator);
    }

    @PostMapping("/update")
    public Educator update(@RequestBody Educator educator) {
        return service.update(educator);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Educator read(@PathVariable String id) {

        Educator educator = service.read(id);
        return educator;
    }

    @GetMapping("/getall")
    public Set<Educator> getAll(){
        return service.getAll();
    }
}