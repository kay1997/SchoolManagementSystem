package com.controller.equipment;

import com.domain.equipment.Chair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.ChairService;

@RestController
@RequestMapping("/chair")
public class ChairController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ChairService service;

    @PostMapping("/create")
    @ResponseBody
    public Chair create(Chair chair) {
        return service.create(chair);
    }

    @PostMapping("/update")
    @ResponseBody
    public Chair update(Chair chair) {
        return service.update(chair);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Chair read(@PathVariable String id) {
        return service.read(id);
    }

}

