package domain;

import java.util.Set;

public class Room {

    private String roomNumber;
    private Set<Chair> chairs;
    private Set<Desk> desks;
    private Set<Projector> projectors;
    private Set<Caretaker> caretaker;

    private Room() {}

    private Room(Builder builder) {
        this.roomNumber = builder.roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public static class Builder {

        private String roomNumber;
        private Set<Chair> chairs;
        private Set<Desk> desks;
        private Set<Projector> projectors;
        private Set<Caretaker> caretaker;

        public Builder roomNumber(String roomNumber)
        {
            this.roomNumber = roomNumber;
            return this;
        }

        public Room build() {
            return new Room(this);
        }

    }
}
