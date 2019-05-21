package com.controller.infrastructure;

import com.domain.infrastructure.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.infrastructure.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {


    @Autowired
    @Qualifier("ServiceImpl")
    private RoomService service;

    @PostMapping("/create")
    @ResponseBody
    public Room create(Room room) {
        return service.create(room);
    }

    @PostMapping("/update")
    @ResponseBody
    public Room update(Room room) {
        return service.update(room);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Room read(@PathVariable String id) {
        return service.read(id);
    }

}