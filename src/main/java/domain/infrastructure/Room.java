package domain.infrastructure;

import domain.equipment.Chair;
import domain.equipment.Desk;
import domain.equipment.Projector;
import domain.people.Caretaker;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
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

        public Builder copy(Room room){
            this.roomNumber = room.roomNumber;

            return this;
        }

        public Room build() {
            return new Room(this);
        }

    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber" + roomNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}

