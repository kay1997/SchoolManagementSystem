package controller.people;

import domain.people.Learner;
import factory.people.LearnerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.people.impl.LearnerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/learner")
public class LearnerController {

    @Autowired
    private LearnerServiceImpl service;

    @GetMapping("/create/{learner}")
    public @ResponseBody
    Learner create(@PathVariable String learnerID, String learnerFirstName, String learnerLastName,
                   String learnerAddress, String learnerTelephoneNumber, int learnerAge)
    {
        Learner learner = LearnerFactory.getLearner(learnerID, learnerFirstName, learnerLastName,
                learnerAddress, learnerTelephoneNumber, learnerAge);
        return service.create(learner);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Learner> getAll() {
        return service.getAll();
    }
}


