package controller.assessments;

import domain.assessments.Test;
import factory.assessments.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.assessments.impl.TestServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/test")
public class TestController {

    @Autowired
    private TestServiceImpl service;

    @GetMapping("/create/{test}")
    public @ResponseBody
    Test create(@PathVariable String testPaperNumber, String testType)
    {
        Test test = TestFactory.getTest(testPaperNumber, testType);
        return service.create(test);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Test> getAll() {
        return service.getAll();
    }
}

