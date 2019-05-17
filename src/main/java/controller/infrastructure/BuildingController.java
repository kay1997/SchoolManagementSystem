package controller.infrastructure;

import domain.infrastructure.Building;
import factory.infrastructure.BuildingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.infrastructure.impl.BuildingServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/building")
public class BuildingController {

    @Autowired
    private BuildingServiceImpl service;

    @GetMapping("/create/{building}")
    public @ResponseBody
    Building create(@PathVariable String buildingNumber, String buildingName)
    {
        Building building = BuildingFactory.getBuilding(buildingNumber, buildingName);
        return service.create(building);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Building> getAll() {
        return service.getAll();
    }
}

