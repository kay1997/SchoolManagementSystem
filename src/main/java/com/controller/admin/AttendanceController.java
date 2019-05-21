package com.controller.admin;

import com.domain.admin.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.admin.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    @Qualifier("ServiceImpl")
    private AttendanceService service;

    @PostMapping("/create")
    @ResponseBody
    public Attendance create(Attendance attendance) {
        return service.create(attendance);
    }

    @PostMapping("/update")
    @ResponseBody
    public Attendance update(Attendance attendance) {
        return service.update(attendance);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Attendance read(@PathVariable String id) {
        return service.read(id);
    }

}