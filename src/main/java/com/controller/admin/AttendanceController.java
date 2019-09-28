package com.controller.admin;

import com.domain.admin.Attendance;
import com.service.admin.impl.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.AttendanceService;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/lookup/Attendance")
public class AttendanceController {

    @Qualifier("AttendanceServiceImpl")
    @Autowired
    private AttendanceServiceImpl service;

    @PostMapping(value = {"/", "/create"} )
    public Attendance create(@RequestBody Attendance attendance) {
        return service.create(attendance);
    }

    @PostMapping("/update")
    public Attendance update(@RequestBody Attendance attendance) {
        return service.update(attendance);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Attendance read(@PathVariable String id) {

        Attendance attendance = service.read(id);
        return attendance;
    }

    @GetMapping("/getall")
    public Set<Attendance> getAll(){
        return service.getAll();
    }

}