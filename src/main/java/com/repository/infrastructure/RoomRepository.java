package com.repository.infrastructure;

import com.domain.infrastructure.Room;
import com.repository.IRepository;

import java.util.Set;

public interface RoomRepository extends IRepository<Room, String> {

    Set<Room> getAll();

}