package com.controller.admin;

import com.domain.admin.Class;
import com.service.admin.impl.ClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.ClassService;

import java.util.Set;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassServiceImpl service;

    @PostMapping("/create")
    public Class create(@RequestBody Class cls) {
        return service.create(cls);
    }

    @PostMapping("/update")
    public Class update(@RequestBody Class cls) {
        return service.update(cls);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Class read(@PathVariable String id) {

        Class cls = service.read(id);
        return cls;
    }

    @GetMapping("/getall")
    public Set<Class> getAll(){
        return service.getAll();
    }
}