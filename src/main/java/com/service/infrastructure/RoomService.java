package com.service.infrastructure;

import com.domain.infrastructure.Room;
import com.service.IService;

import java.util.Set;

public interface RoomService extends IService<Room, String> {

    Set<Room> getAll();

}
