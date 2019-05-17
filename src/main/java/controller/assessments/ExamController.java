package controller.assessments;

import domain.assessments.Exam;
import factory.assessments.ExamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.assessments.impl.ExamServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/exam")
public class ExamController {

    @Autowired
    private ExamServiceImpl service;

    @GetMapping("/create/{exam}")
    public @ResponseBody
    Exam create(@PathVariable String examPaperNumber, String examType)
    {
        Exam exam = ExamFactory.getExam(examPaperNumber, examType);
        return service.create(exam);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Exam> getAll() {
        return service.getAll();
    }
}

