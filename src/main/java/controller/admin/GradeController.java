package controller.admin;

import domain.admin.Grade;
import factory.admin.GradeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.impl.GradeServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/computer")
public class GradeController {

    @Autowired
    private GradeServiceImpl service;

    @GetMapping("/create/{computer}")
    public @ResponseBody
    Grade create(@PathVariable String gradeNumber)
    {
        Grade computer = GradeFactory.getGrade(gradeNumber);
        return service.create(computer);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Grade> getAll() {
        return service.getAll();
    }
}
