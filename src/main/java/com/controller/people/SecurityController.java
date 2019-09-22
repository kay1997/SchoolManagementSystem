package com.controller.people;

import com.domain.people.Security;
import com.service.people.impl.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.people.SecurityService;

import java.util.Set;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private SecurityServiceImpl service;

    @PostMapping("/create")
    public Security create(@RequestBody Security security) {
        return service.create(security);
    }

    @PostMapping("/update")
    public Security update(@RequestBody Security security) {
        return service.update(security);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping(path = "/read/{id}")
    public Security read(@PathVariable String id) {

        Security security = service.read(id);
        return security;
    }

    @GetMapping("/getall")
    public Set<Security> getAll(){
        return service.getAll();
    }

}