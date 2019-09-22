package com.controller.infrastructure;

import com.domain.infrastructure.Lab;
import com.service.infrastructure.impl.LabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.infrastructure.LabService;

import java.util.Set;

@RestController
@RequestMapping("/lab")
public class LabController {

    @Autowired
    private LabServiceImpl service;

    @PostMapping("/create")
    public Lab create(@RequestBody Lab lab) {
        return service.create(lab);
    }

    @PostMapping("/update")
    public Lab update(@RequestBody Lab lab) {
        return service.update(lab);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Lab read(@PathVariable String id) {

        Lab lab = service.read(id);
        return lab;
    }

    @GetMapping("/getall")
    public Set<Lab> getAll() {
        return service.getAll();
    }
}