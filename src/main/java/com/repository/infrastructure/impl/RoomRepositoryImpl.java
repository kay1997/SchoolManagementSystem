package com.repository.infrastructure.impl;

import com.domain.infrastructure.Room;
import com.repository.infrastructure.RoomRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class RoomRepositoryImpl implements RoomRepository {
    private static RoomRepositoryImpl repository = null;
    private Map<String, Room> rooms;

    private RoomRepositoryImpl() {
        this.rooms = new HashMap<>();
    }

    public static RoomRepositoryImpl getRepository() {
        if (repository == null) repository = new RoomRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Room> getAll() {
        Collection<Room> rooms = this.rooms.values();
        Set<Room> set = new HashSet<>();
        set.addAll(rooms);
        return set;
    }

    @Override
    public Room create(Room room) {
        if (read(room.getRoomNumber()) == null) {
            this.rooms.put(room.getRoomNumber(), room);
        }
        return room;
    }

    @Override
    public Room read(String e) {
        return this.rooms.get(e);
    }

    @Override
    public Room update(Room room) {
        if (read(room.getRoomNumber()) != null) {
            rooms.replace(room.getRoomNumber(), room);
        }
        return room;
    }

    @Override
    public void delete(String e) {
        Room room = read(e);
        this.rooms.remove(e, room);
    }

}