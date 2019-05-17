package controller.equipment;

import domain.equipment.Printer;
import factory.equipment.PrinterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.PrinterServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/printer")
public class PrinterController {

    @Autowired
    private PrinterServiceImpl service;

    @GetMapping("/create/{printer}")
    public @ResponseBody
    Printer create(@PathVariable String printerCode, String printerName)
    {
        Printer printer = PrinterFactory.getPrinter(printerCode, printerName);
        return service.create(printer);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Printer> getAll() {
        return service.getAll();
    }
}

