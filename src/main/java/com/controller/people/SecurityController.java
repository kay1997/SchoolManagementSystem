package com.controller.people;

import com.domain.people.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.SecurityService;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    @Qualifier("ServiceImpl")
    private SecurityService service;

    @PostMapping("/create")
    @ResponseBody
    public Security create(Security security) {
        return service.create(security);
    }

    @PostMapping("/update")
    @ResponseBody
    public Security update(Security security) {
        return service.update(security);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Security read(@PathVariable String id) {
        return service.read(id);
    }

}