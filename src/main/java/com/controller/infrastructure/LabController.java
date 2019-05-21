package com.controller.infrastructure;

import com.domain.infrastructure.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.infrastructure.LabService;

@RestController
@RequestMapping("/SchoolManagementSystem/lab")
public class LabController {

    @Autowired
    @Qualifier("ServiceImpl")
    private LabService service;

    @PostMapping("/create")
    @ResponseBody
    public Lab create(Lab lab) {
        return service.create(lab);
    }

    @PostMapping("/update")
    @ResponseBody
    public Lab update(Lab lab) {
        return service.update(lab);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Lab read(@PathVariable String id) {
        return service.read(id);
    }

}
