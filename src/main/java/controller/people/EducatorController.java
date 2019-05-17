package controller.people;

import domain.people.Educator;
import factory.people.EducatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.people.impl.EducatorServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/educator")
public class EducatorController {

    @Autowired
    private EducatorServiceImpl service;

    @GetMapping("/create/{educator}")
    public @ResponseBody
    Educator create(@PathVariable String educatorIDNumber, String educatorFirstName, String educatorLastName,
                    String educatorAddress, String educatorDateOfBirth, String educatorContactNumber, int educatorAge)
    {
        Educator educator = EducatorFactory.getEducator(educatorIDNumber, educatorFirstName, educatorLastName,
                educatorAddress, educatorDateOfBirth, educatorContactNumber, educatorAge);
        return service.create(educator);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Educator> getAll() {
        return service.getAll();
    }
}

