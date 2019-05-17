package controller.admin;

import domain.admin.Subject;
import factory.admin.SubjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.impl.SubjectServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl service;

    @GetMapping("/create/{subject}")
    public @ResponseBody
    Subject create(@PathVariable String subjectCode, String subjectName)
    {
        Subject subject = SubjectFactory.getSubject(subjectCode, subjectName);
        return service.create(subject);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Subject> getAll() {
        return service.getAll();
    }
}

