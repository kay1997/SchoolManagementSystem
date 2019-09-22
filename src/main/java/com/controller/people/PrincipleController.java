package com.controller.people;

import com.domain.people.Principle;
import com.service.people.impl.PrincipleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.PrincipleService;

import java.util.Set;

@RestController
@RequestMapping("/principle")
public class PrincipleController {

    @Autowired
    private PrincipleServiceImpl service;

    @PostMapping("/create")
    public Principle create(@RequestBody Principle principle) {
        return service.create(principle);
    }

    @PostMapping("/update")
    public Principle update(@RequestBody Principle principle) {
        return service.update(principle);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Principle read(@PathVariable String id) {

        Principle principle = service.read(id);
        return principle;
    }

    @GetMapping("/getall")
    public Set<Principle> getAll(){
        return service.getAll();
    }

}

