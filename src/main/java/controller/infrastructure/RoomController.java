package controller.infrastructure;

import domain.infrastructure.Room;
import factory.infrastructure.RoomFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.infrastructure.impl.RoomServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SchoolManagementSystem/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl service;

    @GetMapping("/create/{room}")
    public @ResponseBody
    Room create(@PathVariable String roomNumber)
    {
        Room room = RoomFactory.getRoom(roomNumber);
        return service.create(room);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Room> getAll() {
        return service.getAll();
    }
}

