package controller.people;

import domain.people.Principle;
import factory.people.PrincipleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.people.impl.PrincipleServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/principle")
public class PrincipleController {

    @Autowired
    private PrincipleServiceImpl service;

    @GetMapping("/create/{principle}")
    public @ResponseBody
    Principle create(@PathVariable String principleID, String principleFirstName, String principleLastName,
                     String principleAddress, String principleDateOfBirth, String principleContactNumber, int principleAge)
    {
        Principle principle = PrincipleFactory.getPrinciple(principleID, principleFirstName, principleLastName,
                principleAddress, principleDateOfBirth, principleContactNumber, principleAge);
        return service.create(principle);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Principle> getAll() {
        return service.getAll();
    }
}

