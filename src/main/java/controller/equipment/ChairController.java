package controller.equipment;

import domain.equipment.Chair;
import factory.equipment.ChairFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.ChairServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/chair")
public class ChairController {

    @Autowired
    private ChairServiceImpl service;

    @GetMapping("/create/{chair}")
    public @ResponseBody
    Chair create(@PathVariable String chairNumber)
    {
        Chair chair = ChairFactory.getChair(chairNumber);
        return service.create(chair);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Chair> getAll() {
        return service.getAll();
    }
}


