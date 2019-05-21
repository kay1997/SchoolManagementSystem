package com.controller.people;

import com.domain.people.Principle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.PrincipleService;

@RestController
@RequestMapping("/principle")
public class PrincipleController {

    @Autowired
    @Qualifier("ServiceImpl")
    private PrincipleService service;

    @PostMapping("/create")
    @ResponseBody
    public Principle create(Principle principle) {
        return service.create(principle);
    }

    @PostMapping("/update")
    @ResponseBody
    public Principle update(Principle principle) {
        return service.update(principle);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Principle read(@PathVariable String id) {
        return service.read(id);
    }

}

