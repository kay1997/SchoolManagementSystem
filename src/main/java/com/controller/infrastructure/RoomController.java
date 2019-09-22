package com.controller.infrastructure;

import com.domain.infrastructure.Room;
import com.service.infrastructure.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.service.infrastructure.RoomService;

import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl service;

    @PostMapping("/create")
    public Room create(@RequestBody Room room) {
        return service.create(room);
    }

    @PostMapping("/update")
    public Room update(@RequestBody Room room) {
        return service.update(room);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping(path = "/read/{id}")
    public Room read(@PathVariable String id) {

        Room room = service.read(id);
        return room;
    }

    @GetMapping("/getall")
    public Set<Room> getAll(){
        return service.getAll();
    }

}