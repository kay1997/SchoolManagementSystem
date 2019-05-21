package com.controller.people;

import com.domain.people.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.LearnerService;

@RestController
@RequestMapping("/learner")
public class LearnerController {

    @Autowired
    @Qualifier("ServiceImpl")
    private LearnerService service;

    @PostMapping("/create")
    @ResponseBody
    public Learner create(Learner learner) {
        return service.create(learner);
    }

    @PostMapping("/update")
    @ResponseBody
    public Learner update(Learner learner) {
        return service.update(learner);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Learner read(@PathVariable String id) {
        return service.read(id);
    }

}
