package com.controller.admin;

import com.domain.admin.Grade;
import com.factory.admin.GradeFactory;
import com.service.admin.impl.GradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.GradeService;

import java.util.Set;

@RestController
@RequestMapping("SchoolManagementSystem/lookup/Grade")
public class GradeController {

    @Autowired
    private GradeServiceImpl service;

    @PostMapping(value = {"/", "/create"} )
    public Grade create(@RequestBody Grade grade) {
        return service.create(grade);
    }

    @PostMapping("/update")
    public Grade update(@RequestBody Grade grade) {
        return service.update(grade);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Grade read(@PathVariable String id) {

        Grade grade = service.read(id);
        return grade;
    }

    @GetMapping("/getall")
    public Set<Grade> getAll(){
        return service.getAll();
    }
}