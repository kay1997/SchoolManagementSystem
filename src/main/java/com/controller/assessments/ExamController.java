package com.controller.assessments;
import com.domain.assessments.Exam;
import com.service.assessments.impl.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.assessments.ExamService;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamServiceImpl service;

    @PostMapping("/create")
    public Exam create(@RequestBody Exam exam) {
        return service.create(exam);
    }

    @PostMapping("/update")
    public Exam update(@RequestBody Exam exam) {
        return service.update(exam);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Exam read(@PathVariable String id) {

        Exam exam = service.read(id);
        return exam;
    }

    @GetMapping("/getall")
    public Set<Exam> getAll(){
        return service.getAll();
    }


}

