package com.controller.people;

import com.domain.people.Secretary;
import com.service.people.impl.SecretaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.SecretaryService;

import java.util.Set;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryServiceImpl service;

    @PostMapping("/create")
    public Secretary create(@RequestBody Secretary secretary) {
        return service.create(secretary);
    }

    @PostMapping("/update")
    public Secretary update(@RequestBody Secretary secretary) {
        return service.update(secretary);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Secretary read(@PathVariable String id) {

        Secretary secretary = service.read(id);
        return secretary;
    }

    @GetMapping("/getall")
    public Set<Secretary> getAll(){
        return service.getAll();
    }

}

