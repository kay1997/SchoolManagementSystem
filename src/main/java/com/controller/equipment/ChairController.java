package com.controller.equipment;

import com.domain.equipment.Chair;
import com.service.equipment.impl.ChairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.ChairService;

import java.util.Set;

@RestController
@RequestMapping("/chair")
public class ChairController {

    @Autowired
    private ChairServiceImpl service;

    @PostMapping("/create")
    public Chair create(@RequestBody Chair chair) {
        return service.create(chair);
    }

    @PostMapping("/update")
    public Chair update(@RequestBody Chair chair) {
        return service.update(chair);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Chair read(@PathVariable String id) {

        Chair chair = service.read(id);
        return chair;
    }

    @GetMapping("/getall")
    public Set<Chair> getAll(){
        return service.getAll();
    }

}

