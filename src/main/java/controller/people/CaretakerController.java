package controller.people;

import domain.people.Caretaker;
import factory.people.CaretakerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.people.impl.CaretakerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/caretaker")
public class CaretakerController {

    @Autowired
    private CaretakerServiceImpl service;

    @GetMapping("/create/{caretaker}")
    public @ResponseBody
    Caretaker create(@PathVariable String caretakerIDNumber, String caretakerFirstName, String caretakerLastName,
                     String caretakerAddress, String caretakerDateOfBirth, String caretakerContactNumber, int caretakerAge)
    {
        Caretaker caretaker = CaretakerFactory.getCaretaker(caretakerIDNumber, caretakerFirstName, caretakerLastName,
                caretakerAddress, caretakerDateOfBirth, caretakerContactNumber, caretakerAge);
        return service.create(caretaker);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Caretaker> getAll() {
        return service.getAll();
    }
}

