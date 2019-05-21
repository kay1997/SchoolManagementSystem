package com.controller.admin;

import com.domain.admin.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    @Qualifier("ServiceImpl")
    private SchoolService service;

    @PostMapping("/create")
    @ResponseBody
    public School create(School school) {
        return service.create(school);
    }

    @PostMapping("/update")
    @ResponseBody
    public School update(School school) {
        return service.update(school);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public School read(@PathVariable String id) {
        return service.read(id);
    }

}