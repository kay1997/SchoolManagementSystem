package com.domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.print.DocFlavor;
import java.util.Objects;

@EntityScan
public class Chair {

    private String chairNumber;
    private String chairType;

    public Chair(){}

    private Chair(Builder builder){
        this.chairNumber = builder.chairNumber;
        this.chairType = builder.chairType;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
    }

    public void setChairType(String chairType) {
        this.chairType = chairType;
    }

    public String getChairType(){
        return chairType;
    }

    public static class Builder{

        private String chairNumber;
        private String chairType;

        public Builder chairNumber(String chairNumber)
        {
            this.chairNumber = chairNumber;
            return this;
        }

        public Builder chairType(String chairType)
        {
            this.chairType = chairType;
            return this;
        }


        public Builder copy(Chair chair){
            this.chairNumber = chair.chairNumber;
            this.chairType = chair.chairType;

            return this;
        }

        public Chair build()
        {
            return new Chair(this);
        }
    }

    @Override
    public String toString() {
        return "Chair) {" +
                "chairNumber" + chairNumber + '\'' +
                "chairType" + chairType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return chairNumber.equals(chair.chairNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chairNumber);
    }
}
