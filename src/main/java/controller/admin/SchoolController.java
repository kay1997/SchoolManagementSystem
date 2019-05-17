package controller.admin;

import domain.admin.School;
import factory.admin.SchoolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.impl.SchoolServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/school")
public class SchoolController {

    @Autowired
    private SchoolServiceImpl service;

    @GetMapping("/create/{school}")
    public @ResponseBody
    School create(@PathVariable String schoolCode, String schoolName, String schoolAddress, String schoolContactNumber)
    {
        School school = SchoolFactory.getSchool(schoolCode, schoolName, schoolAddress, schoolContactNumber);
        return service.create(school);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<School> getAll() {
        return service.getAll();
    }
}
