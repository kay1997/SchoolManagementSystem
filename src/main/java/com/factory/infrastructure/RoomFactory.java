package com.factory.infrastructure;

import com.domain.infrastructure.Room;

public class RoomFactory {

    public static Room getRoom(String roomNumber) {
        return new Room.Builder().roomNumber(roomNumber).build();
    }
}
