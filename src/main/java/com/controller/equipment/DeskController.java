package com.controller.equipment;

import com.domain.equipment.Desk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.DeskService;

@RestController
@RequestMapping("/desk")
public class DeskController {

    @Autowired
    @Qualifier("ServiceImpl")
    private DeskService service;

    @PostMapping("/create")
    @ResponseBody
    public Desk create(Desk desk) {
        return service.create(desk);
    }

    @PostMapping("/update")
    @ResponseBody
    public Desk update(Desk desk) {
        return service.update(desk);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Desk read(@PathVariable String id) {
        return service.read(id);
    }

}