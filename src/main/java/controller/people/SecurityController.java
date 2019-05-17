package controller.people;

import domain.people.Security;
import factory.people.SecurityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.people.impl.SecurityServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/security")
public class SecurityController {

    @Autowired
    private SecurityServiceImpl service;

    @GetMapping("/create/{security}")
    public @ResponseBody
    Security create(@PathVariable String securityIDNumber, String securityFirstName, String securityLastName,
                    String securityAddress, String securityDateOfBirth, String securityContactNumber, int securityAge)
    {
        Security security = SecurityFactory.getSecurity(securityIDNumber, securityFirstName, securityLastName,
                securityAddress, securityDateOfBirth, securityContactNumber, securityAge);
        return service.create(security);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Security> getAll() {
        return service.getAll();
    }
}

