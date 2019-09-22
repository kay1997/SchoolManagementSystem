package com.factory.infrastructure;

import com.domain.infrastructure.Room;

public class RoomFactory {

    public static Room getRoom(String roomNumber, String roomType) {
        return new Room.Builder().roomNumber(roomNumber).roomType(roomType).build();
    }
}
