package com.domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Desk {

    private String deskNumber;
    private String deskType;

    public Desk(){}

    private Desk(Builder builder)
    {
        this.deskNumber = builder.deskNumber;
        this.deskType = builder.deskType;
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    public void setDeskType(String deskType) {
        this.deskType = deskType;
    }

    public String getDeskType(){return deskType;}

    public static class Builder{

        private String deskNumber;
        private String deskType;

        public Builder deskNumber(String deskNumber){

            this.deskNumber = deskNumber;
            return this;
        }

        public Builder deskType(String deskType)
        {
            this.deskType = deskType;
            return this;
        }

        public Builder copy(Desk desk){

            this.deskNumber = desk.deskNumber;
            this.deskType = desk.deskType;

            return this;
        }

        public Desk build()
        {
            return new Desk(this);
        }
    }

    @Override
    public String toString() {
        return "Desk{" +
                "deskNumber" + deskNumber + '\'' +
                "deskType" + deskType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desk desk = (Desk) o;
        return deskNumber.equals(desk.deskNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deskNumber);
    }
}
