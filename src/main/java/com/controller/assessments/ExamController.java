package com.controller.assessments;
import com.domain.assessments.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.assessments.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ExamService service;

    @PostMapping("/create")
    @ResponseBody
    public Exam create(Exam exam) {
        return service.create(exam);
    }

    @PostMapping("/update")
    @ResponseBody
    public Exam update(Exam exam) {
        return service.update(exam);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Exam read(@PathVariable String id) {
        return service.read(id);
    }

}

