package com.domain.infrastructure;

import com.domain.people.Security;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Building {

    private String buildingNumber;
    private String buildingName;
    private Set<Room> rooms;
    private Set<Lab> labs;
    private Set<Security> security;


    private Building() {}

    private Building(Builder builder)
    {
        this.buildingName = builder.buildingName;
        this.buildingNumber = builder.buildingNumber;
    }

    public String getBuildingNumber()
    {
        return buildingNumber;
    }

    public String getBuildingName()
    { return buildingName;
    }


    public static class Builder {

        private String buildingNumber;
        private String buildingName;
        private Set<Room> rooms;
        private Set<Lab> labs;
        private Set<Security> security;

        public Builder buildingNumber(String buildingNumber)
        {
            this.buildingNumber = buildingNumber;
            return this;
        }

        public Builder buildingName(String buildingName)
        {
            this.buildingName = buildingName;
            return this;
        }

        public Builder copy(Building building){
            this.buildingNumber = building.buildingNumber;
            this.buildingName = building.buildingName;

            return this;
        }

        public Building build() {
            return new Building(this);
        }

    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingNumber" + buildingNumber + '\'' +
                "buildingName" + buildingName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return buildingNumber.equals(building.buildingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingNumber);
    }

}

