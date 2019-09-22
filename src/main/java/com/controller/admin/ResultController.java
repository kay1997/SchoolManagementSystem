package com.controller.admin;

import com.domain.admin.Result;
import com.service.admin.impl.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.ResultService;

import java.util.Set;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultServiceImpl service;

    @PostMapping("/create")
    public Result create(@RequestBody Result result) {
        return service.create(result);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Result result) {
        return service.update(result);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Result read(@PathVariable String id) {

        Result result = service.read(id);
        return result;
    }

    @GetMapping("/getall")
    public Set<Result> getAll() {
        return service.getAll();
    }
}