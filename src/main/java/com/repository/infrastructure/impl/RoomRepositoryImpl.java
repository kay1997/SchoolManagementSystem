package com.repository.infrastructure.impl;

import com.domain.infrastructure.Room;
import com.repository.infrastructure.RoomRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class RoomRepositoryImpl implements RoomRepository {

    private static RoomRepositoryImpl repository = null;
    private Set<Room> rooms;

    private RoomRepositoryImpl(){
        this.rooms = new HashSet<>();
    }

    public static RoomRepositoryImpl getRepository(){
        if (repository == null) repository = new RoomRepositoryImpl();
        return repository;
    }


    public Room create(Room room){
        this.rooms.add(room);
        return room;
    }

    private Room findRoom(String roomNumber) {
        return this.rooms.stream()
                .filter(room -> room.getRoomNumber().trim().equals(roomNumber))
                .findAny()
                .orElse(null);
    }

    public Room read(String roomNumber){

        Room room = findRoom(roomNumber);
        return room;
    }

    public void delete(String roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null) this.rooms.remove(room);

    }

    public Room update(Room room) {
        Room toDelete = findRoom(room.getRoomNumber());
        if (toDelete != null) {
            this.rooms.remove(toDelete);
            return create(room);
        }
        return null;
    }

    public Set<Room> getAll(){
        return this.rooms;
    }
}
