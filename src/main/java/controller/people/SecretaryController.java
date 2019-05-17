package controller.people;

import domain.people.Secretary;
import factory.people.SecretaryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.people.impl.SecretaryServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryServiceImpl service;

    @GetMapping("/create/{secretary}")
    public @ResponseBody
    Secretary create(@PathVariable String secretaryIDNumber, String secretaryFirstName, String secretaryLastName,
                     String secretaryAddress, String secretaryDateOfBirth, String secretaryContactNumber, int secretaryAge)
    {
        Secretary secretary = SecretaryFactory.getSecretary(secretaryIDNumber, secretaryFirstName, secretaryLastName,
                secretaryAddress, secretaryDateOfBirth, secretaryContactNumber, secretaryAge);
        return service.create(secretary);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Secretary> getAll() {
        return service.getAll();
    }
}

