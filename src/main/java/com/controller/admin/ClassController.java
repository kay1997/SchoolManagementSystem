package com.controller.admin;

import com.domain.admin.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.ClassService;

@RestController
@RequestMapping("oneClass")
public class ClassController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ClassService service;

    @PostMapping("/create")
    @ResponseBody
    public Class create(Class oneClass) {
        return service.create(oneClass);
    }

    @PostMapping("/update")
    @ResponseBody
    public Class update(Class oneClass) {
        return service.update(oneClass);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Class read(@PathVariable String id) {
        return service.read(id);
    }

}