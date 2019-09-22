package com.controller.infrastructure;

import com.domain.infrastructure.Building;
import com.service.infrastructure.impl.BuildingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.infrastructure.BuildingService;

import java.util.Set;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingServiceImpl service;

    @PostMapping("/create")
    public Building create(@RequestBody Building building) {
        return service.create(building);
    }

    @PostMapping("/update")
    public Building update(@RequestBody Building building) {
        return service.update(building);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Building read(@PathVariable String id) {

        Building building = service.read(id);
        return building;
    }

    @GetMapping("/getall")
    public Set<Building> getAll(){
        return service.getAll();
    }

}
