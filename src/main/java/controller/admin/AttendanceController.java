package controller.admin;

import domain.admin.Attendance;
import factory.admin.AttendanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.impl.AttendanceServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceServiceImpl service;

    @GetMapping("/create/{attendance}")
    public @ResponseBody
    Attendance create(@PathVariable int noOfDaysAbsent, String noOfDaysPresent)
    {
        Attendance attendance = AttendanceFactory.getAttendance(noOfDaysAbsent, noOfDaysPresent);
        return service.create(attendance);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Attendance> getAll() {
        return service.getAll();
    }
}
