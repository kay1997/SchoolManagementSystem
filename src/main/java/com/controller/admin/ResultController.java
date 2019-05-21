package com.controller.admin;

import com.domain.admin.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ResultService service;

    @PostMapping("/create")
    @ResponseBody
    public Result create(Result result) {
        return service.create(result);
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(Result result) {
        return service.update(result);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Result read(@PathVariable String id) {
        return service.read(id);
    }

}

