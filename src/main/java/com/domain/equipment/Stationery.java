package com.domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Stationery {

    private String stationeryCode;
    private String stationeryType;

    private Stationery(){}

    private Stationery(Builder builder)
    {
        this.stationeryCode = builder.stationeryCode;
        this.stationeryType = builder.stationeryType;
    }

    public String getStationeryCode() {
        return stationeryCode;
    }

    public String getStationeryType() {
        return stationeryType;
    }

    public static class Builder {

        private String stationeryCode;
        private String stationeryType;

        public Builder stationeryCode(String stationeryCode)
        {
            this.stationeryCode = stationeryCode;
            return this;
        }

        public Builder stationeryType(String stationeryType)
        {
            this.stationeryType = stationeryType;
            return this;
        }

        public Builder copy(Stationery stationery){
            this.stationeryCode = stationery.stationeryCode;
            this.stationeryType = stationery.stationeryType;

            return this;
        }

        public Stationery build()
        {
            return new Stationery(this);
        }
    }

    @Override
    public String toString() {
        return "Stationery {" +
                "stationeryCode" + stationeryCode + '\'' +
                "stationeryType" + stationeryType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stationery stationery = (Stationery) o;
        return stationeryCode.equals(stationery.stationeryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationeryCode);
    }
}
