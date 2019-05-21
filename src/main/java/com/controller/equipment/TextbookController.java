package com.controller.equipment;

import com.domain.equipment.Textbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.equipment.TextbookService;

@RestController
@RequestMapping("/textbook")
public class TextbookController {

    @Autowired
    @Qualifier("ServiceImpl")
    private TextbookService service;

    @PostMapping("/create")
    @ResponseBody
    public Textbook create(Textbook textbook) {
        return service.create(textbook);
    }

    @PostMapping("/update")
    @ResponseBody
    public Textbook update(Textbook textbook) {
        return service.update(textbook);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Textbook read(@PathVariable String id) {
        return service.read(id);
    }

}