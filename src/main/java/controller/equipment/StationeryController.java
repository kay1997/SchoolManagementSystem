package controller.equipment;

import domain.equipment.Stationery;
import factory.equipment.StationeryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.StationeryServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/stationery")
public class StationeryController {

    @Autowired
    private StationeryServiceImpl service;

    @GetMapping("/create/{stationery}")
    public @ResponseBody
    Stationery create(@PathVariable String stationeryCode, String stationeryType)
    {
        Stationery stationery = StationeryFactory.getStationery(stationeryCode, stationeryType);
        return service.create(stationery);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Stationery> getAll() {
        return service.getAll();
    }
}

