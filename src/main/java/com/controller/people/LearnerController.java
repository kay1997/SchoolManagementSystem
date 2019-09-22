package com.controller.people;

import com.domain.people.Learner;
import com.service.people.impl.LearnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.LearnerService;

import java.util.Set;

@RestController
@RequestMapping("/learner")
public class LearnerController {

    @Autowired
    private LearnerServiceImpl service;

    @PostMapping("/create")
    public Learner create(@RequestBody Learner learner) {
        return service.create(learner);
    }

    @PostMapping("/update")
    public Learner update(@RequestBody Learner learner) {
        return service.update(learner);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Learner read(@PathVariable String id) {

        Learner learner = service.read(id);
        return learner;
    }

    @GetMapping("/getall")
    public Set<Learner> getAll() {
        return service.getAll();
    }
}