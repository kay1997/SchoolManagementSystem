package com.controller.people;

import com.domain.people.Secretary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.SecretaryService;

@RestController
@RequestMapping("/SchoolManagementSystem/secretary")
public class SecretaryController {

    @Autowired
    @Qualifier("ServiceImpl")
    private SecretaryService service;

    @PostMapping("/create")
    @ResponseBody
    public Secretary create(Secretary secretary) {
        return service.create(secretary);
    }

    @PostMapping("/update")
    @ResponseBody
    public Secretary update(Secretary secretary) {
        return service.update(secretary);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Secretary read(@PathVariable String id) {
        return service.read(id);
    }

}

