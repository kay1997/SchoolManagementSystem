package domain;

import java.util.Set;

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

        public Building build() {
            return new Building(this);
        }

    }

}

