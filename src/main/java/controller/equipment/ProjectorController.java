package controller.equipment;

import domain.equipment.Projector;
import factory.equipment.ProjectorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.ProjectorServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/projector")
public class ProjectorController {

    @Autowired
    private ProjectorServiceImpl service;

    @GetMapping("/create/{projector}")
    public @ResponseBody
    Projector create(@PathVariable String projectorCode, String projectorName)
    {
        Projector projector = ProjectorFactory.getProjector(projectorCode, projectorName);
        return service.create(projector);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Projector> getAll() {
        return service.getAll();
    }
}

