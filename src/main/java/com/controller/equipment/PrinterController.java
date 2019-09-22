package com.controller.equipment;

import com.domain.equipment.Printer;
import com.service.equipment.impl.PrinterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.PrinterService;

import java.util.Set;

@RestController
@RequestMapping("/printer")
public class PrinterController {

    @Autowired
    private PrinterServiceImpl service;

    @PostMapping("/create")
    public Printer create(@RequestBody Printer printer) {
        return service.create(printer);
    }

    @PostMapping("/update")
    public Printer update(@RequestBody Printer printer) {
        return service.update(printer);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Printer read(@PathVariable String id) {

        Printer printer = service.read(id);
        return printer;
    }

    @GetMapping("/getall")
    public Set<Printer> getAll(){
        return service.getAll();
    }


}