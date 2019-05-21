package com.controller.equipment;

import com.domain.equipment.Projector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.ProjectorService;

@RestController
@RequestMapping("/projector")
public class ProjectorController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ProjectorService service;

    @PostMapping("/create")
    @ResponseBody
    public Projector create(Projector projector) {
        return service.create(projector);
    }

    @PostMapping("/update")
    @ResponseBody
    public Projector update(Projector projector) {
        return service.update(projector);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Projector read(@PathVariable String id) {
        return service.read(id);
    }

}