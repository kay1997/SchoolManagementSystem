package controller.equipment;

import domain.equipment.Textbook;
import factory.equipment.TextbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.equipment.impl.TextbookServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/textbook")
public class TextbookController {

    @Autowired
    private TextbookServiceImpl service;

    @GetMapping("/create/{textbook}")
    public @ResponseBody
    Textbook create(@PathVariable String textbookCode, String textbookName)
    {
        Textbook textbook = TextbookFactory.getTextbook(textbookCode, textbookCode);
        return service.create(textbook);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Textbook> getAll() {
        return service.getAll();
    }
}

