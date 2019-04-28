package factory;

import domain.Room;

public class RoomFactory {

    public static Room getRoom(String roomNumber) {
        return new Room.Builder().roomNumber(roomNumber).build();
    }
}
