package com.controller.people;

import com.domain.people.Caretaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.service.people.CaretakerService;

@RestController
@RequestMapping("/caretaker")
public class CaretakerController {

    @Autowired
    @Qualifier("ServiceImpl")
    private CaretakerService service;

    @PostMapping("/create")
    @ResponseBody
    public Caretaker create(Caretaker caretaker) {
        return service.create(caretaker);
    }

    @PostMapping("/update")
    @ResponseBody
    public Caretaker update(Caretaker caretaker) {
        return service.update(caretaker);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Caretaker read(@PathVariable String id) {
        return service.read(id);
    }

}