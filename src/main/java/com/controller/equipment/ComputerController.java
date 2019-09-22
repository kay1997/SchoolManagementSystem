package com.controller.equipment;

import com.domain.equipment.Computer;
import com.service.equipment.impl.ComputerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.ComputerService;

import java.util.Set;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerServiceImpl service;

    @PostMapping("/create")
    public Computer create(@RequestBody Computer computer) {
        return service.create(computer);
    }

    @PostMapping("/update")
    public Computer update(@RequestBody Computer computer) {
        return service.update(computer);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Computer read(@PathVariable String id) {

        Computer computer = service.read(id);
        return computer;
    }

    @GetMapping("/getall")
    public Set<Computer> getAll(){
        return service.getAll();
    }

}