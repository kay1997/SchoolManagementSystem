package com.controller.equipment;

import com.domain.equipment.Stationery;
import com.service.equipment.impl.StationeryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.StationeryService;

import java.util.Set;

@RestController
@RequestMapping("/stationery")
public class StationeryController {

    @Autowired
    private StationeryServiceImpl service;

    @PostMapping("/create")
    public Stationery create(@RequestBody Stationery stationery) {
        return service.create(stationery);
    }

    @PostMapping("/update")
    public Stationery update(@RequestBody Stationery stationery) {
        return service.update(stationery);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Stationery read(@PathVariable String id) {

        Stationery stationery = service.read(id);
        return stationery;
    }

    @GetMapping("/getall")
    public Set<Stationery> getAll(){
        return service.getAll();
    }


}