package com.controller.equipment;

import com.domain.equipment.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.ComputerService;

@RestController
@RequestMapping("/computer")
class ComputerController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ComputerService service;

    @PostMapping("/create")
    @ResponseBody
    public Computer create(Computer computer) {
        return service.create(computer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Computer update(Computer computer) {
        return service.update(computer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Computer read(@PathVariable String id) {
        return service.read(id);
    }

}