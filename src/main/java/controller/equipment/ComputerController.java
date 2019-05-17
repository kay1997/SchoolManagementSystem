package controller.equipment;

import domain.equipment.Computer;
import factory.equipment.ComputerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.ComputerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/computer")
public class ComputerController {

    @Autowired
    private ComputerServiceImpl service;

    @GetMapping("/create/{computer}")
    public @ResponseBody
    Computer create(@PathVariable String computerNumber, String computerName)
    {
        Computer computer = ComputerFactory.getComputer(computerNumber, computerName);
        return service.create(computer);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Computer> getAll() {
        return service.getAll();
    }
}


