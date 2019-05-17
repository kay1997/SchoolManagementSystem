package factory.infrastructure;

import domain.infrastructure.Room;

public class RoomFactory {

    public static Room getRoom(String roomNumber) {
        return new Room.Builder().roomNumber(roomNumber).build();
    }
}
