package controller.equipment;

import domain.equipment.Desk;
import factory.equipment.DeskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.DeskServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/desk")
public class DeskController {

    @Autowired
    private DeskServiceImpl service;

    @GetMapping("/create/{desk}")
    public @ResponseBody
    Desk create(@PathVariable String deskNumber)
    {
        Desk desk = DeskFactory.getDesk(deskNumber);
        return service.create(desk);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Desk> getAll() {
        return service.getAll();
    }
}
