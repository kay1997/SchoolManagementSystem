package com.controller.equipment;

import com.domain.equipment.Textbook;
import com.service.equipment.impl.TextbookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.TextbookService;

import java.util.Set;

@RestController
@RequestMapping("/textbook")
public class TextbookController {

    @Autowired
    private TextbookServiceImpl service;

    @PostMapping("/create")
    public Textbook create(@RequestBody Textbook textbook) {
        return service.create(textbook);
    }

    @PostMapping("/update")
    public Textbook update(@RequestBody Textbook textbook) {
        return service.update(textbook);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Textbook read(@PathVariable String id) {

        Textbook textbook = service.read(id);
        return textbook;
    }

    @GetMapping("/getall")
    public Set<Textbook> getAll(){
        return service.getAll();
    }

}