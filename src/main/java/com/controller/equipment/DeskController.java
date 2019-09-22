package com.controller.equipment;

import com.domain.equipment.Desk;
import com.service.equipment.impl.DeskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.DeskService;

import java.util.Set;

@RestController
@RequestMapping("/desk")
public class DeskController {

    @Autowired
    private DeskServiceImpl service;

    @PostMapping("/create")
    public Desk create(@RequestBody Desk desk) {
        return service.create(desk);
    }

    @PostMapping("/update")
    public Desk update(@RequestBody Desk desk) {
        return service.update(desk);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Desk read(@PathVariable String id) {

        Desk desk = service.read(id);
        return desk;
    }

    @GetMapping("/getall")
    public Set<Desk> getAll(){
        return service.getAll();
    }

}