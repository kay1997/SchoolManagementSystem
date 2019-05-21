package com.controller.infrastructure;

import com.domain.infrastructure.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.infrastructure.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    @Qualifier("ServiceImpl")
    private BuildingService service;

    @PostMapping("/create")
    @ResponseBody
    public Building create(Building building) {
        return service.create(building);
    }

    @PostMapping("/update")
    @ResponseBody
    public Building update(Building building) {
        return service.update(building);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Building read(@PathVariable String id) {
        return service.read(id);
    }

}
