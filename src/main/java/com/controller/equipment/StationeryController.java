package com.controller.equipment;

import com.domain.equipment.Stationery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.StationeryService;

@RestController
@RequestMapping("/stationery")
public class StationeryController {

    @Autowired
    @Qualifier("ServiceImpl")
    private StationeryService service;

    @PostMapping("/create")
    @ResponseBody
    public Stationery create(Stationery stationery) {
        return service.create(stationery);
    }

    @PostMapping("/update")
    @ResponseBody
    public Stationery update(Stationery stationery) {
        return service.update(stationery);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Stationery read(@PathVariable String id) {
        return service.read(id);
    }

}