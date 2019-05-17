package controller.admin;

import domain.admin.Class;
import factory.admin.ClassFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.impl.ClassServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/oneClass")
public class ClassController {

    @Autowired
    private ClassServiceImpl service;

    @GetMapping("/create/{oneClass}")
    public @ResponseBody
    Class create(@PathVariable String classGroup)
    {
        Class oneClass = ClassFactory.getClass(classGroup);
        return service.create(oneClass);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Class> getAll() {
        return service.getAll();
    }
}

