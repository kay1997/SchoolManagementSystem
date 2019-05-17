package controller.infrastructure;

import domain.infrastructure.Lab;
import factory.infrastructure.LabFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.infrastructure.impl.LabServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/lab")
public class LabController {

    @Autowired
    private LabServiceImpl service;

    @GetMapping("/create/{lab}")
    public @ResponseBody
    Lab create(@PathVariable String labNumber, String labType)
    {
        Lab lab = LabFactory.getLab(labNumber, labType);
        return service.create(lab);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Lab> getAll() {
        return service.getAll();
    }
}
