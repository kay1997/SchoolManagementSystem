package com.controller.admin;

import com.domain.admin.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    @Qualifier("ServiceImpl")
    private GradeService service;

    @PostMapping("/create")
    @ResponseBody
    public Grade create(Grade grade) {
        return service.create(grade);
    }

    @PostMapping("/update")
    @ResponseBody
    public Grade update(Grade grade) {
        return service.update(grade);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Grade read(@PathVariable String id) {
        return service.read(id);
    }

}