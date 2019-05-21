package com.controller.equipment;

import com.domain.equipment.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.PrinterService;

@RestController
@RequestMapping("/printer")
public class PrinterController {

    @Autowired
    @Qualifier("ServiceImpl")
    private PrinterService service;

    @PostMapping("/create")
    @ResponseBody
    public Printer create(Printer printer) {
        return service.create(printer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Printer update(Printer printer) {
        return service.update(printer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Printer read(@PathVariable String id) {
        return service.read(id);
    }

}