package com.controller.equipment;

import com.domain.equipment.Projector;
import com.service.equipment.impl.ProjectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.ProjectorService;

import java.util.Set;

@RestController
@RequestMapping("/projector")
public class ProjectorController {

    @Autowired
    private ProjectorServiceImpl service;

    @PostMapping("/create")
    public Projector create(@RequestBody Projector projector) {
        return service.create(projector);
    }

    @PostMapping("/update")
    public Projector update(@RequestBody Projector projector) {
        return service.update(projector);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Projector read(@PathVariable String id) {

        Projector projector = service.read(id);
        return projector;
    }

    @GetMapping("/getall")
    public Set<Projector> getAll(){
        return service.getAll();
    }

}