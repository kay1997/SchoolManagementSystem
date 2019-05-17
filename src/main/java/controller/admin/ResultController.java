package controller.admin;

import domain.admin.Result;
import factory.admin.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.impl.ResultServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/result")
public class ResultController {

    @Autowired
    private ResultServiceImpl service;

    @GetMapping("/create/{result}")
    public @ResponseBody
    Result create(@PathVariable String subjectMark)
    {
        Result result = ResultFactory.getResult(subjectMark);
        return service.create(result);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Result> getAll() {
        return service.getAll();
    }
}

