package com.service.infrastructure.impl;

import com.domain.infrastructure.Room;
import com.service.infrastructure.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.infrastructure.RoomRepository;
import com.repository.infrastructure.impl.RoomRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class RoomServiceImpl implements RoomService {
    @Autowired
    @Qualifier("InMemory")
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