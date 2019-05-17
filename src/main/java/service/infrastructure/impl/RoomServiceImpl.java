package service.infrastructure.impl;

import domain.infrastructure.Room;
import org.springframework.stereotype.Service;
import repository.infrastructure.RoomRepository;
import repository.infrastructure.impl.RoomRepositoryImpl;
import service.infrastructure.RoomService;

import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomServiceImpl service = null;
    private RoomRepository repository;

    private RoomServiceImpl() {
        this.repository = RoomRepositoryImpl.getRepository();
    }

    public RoomService getService() {
        if (service == null) service = new RoomServiceImpl();
        return service;
    }

    @Override
    public Room create(Room room) {
        return this.repository.create(room);
    }

    @Override
    public Room update(Room room) {
        return this.repository.update(room);
    }

    @Override
    public void delete(String roomNumber) {
        this.repository.delete(roomNumber);
    }

    @Override
    public Room read(String roomNumber) {
        return this.repository.read(roomNumber);
    }

    @Override
    public Set<Room> getAll() {
        return this.repository.getAll();
    }

}