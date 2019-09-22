package com.controller.people;

import com.domain.people.Caretaker;
import com.service.people.impl.CaretakerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.service.people.CaretakerService;

import java.util.Set;

@RestController
@RequestMapping("/caretaker")
public class CaretakerController {

    @Autowired
    private CaretakerServiceImpl service;

    @PostMapping("/create")
    public Caretaker create(@RequestBody Caretaker caretaker) {
        return service.create(caretaker);
    }

    @PostMapping("/update")
    public Caretaker update(@RequestBody Caretaker caretaker) {
        return service.update(caretaker);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Caretaker read(@PathVariable String id) {

        Caretaker caretaker = service.read(id);
        return caretaker;
    }

    @GetMapping("/getall")
    public Set<Caretaker> getAll(){
        return service.getAll();
    }

}