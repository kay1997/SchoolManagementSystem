package com.domain.infrastructure;

import com.domain.equipment.Chair;
import com.domain.equipment.Desk;
import com.domain.equipment.Projector;
import com.domain.people.Caretaker;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Room {

    private String roomNumber;
    private String roomType;
    private Set<Chair> chairs;
    private Set<Desk> desks;
    private Set<Projector> projectors;
    private Set<Caretaker> caretaker;

    private Room(){}

    private Room(Builder builder) {
        this.roomNumber = builder.roomNumber;
        this.roomType = builder.roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType(){return roomType;}

    public static class Builder {

        private String roomNumber;
        private String roomType;
        private Set<Chair> chairs;
        private Set<Desk> desks;
        private Set<Projector> projectors;
        private Set<Caretaker> caretaker;

        public Builder roomNumber(String roomNumber)
        {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder roomType(String roomType)
        {
            this.roomType = roomType;
            return this;
        }

        public Builder copy(Room room){
            this.roomNumber = room.roomNumber;
            this.roomType = room.roomType;

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
                "roomType" + roomType + '\'' +
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

