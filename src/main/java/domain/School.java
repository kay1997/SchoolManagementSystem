package domain;

import java.util.Set;

public class School {

    private String schoolCode;
    private String schoolName, schoolContactNumber, schoolAddress;
    private Set<Building> buildings;
    private Set<Stationery> stationerySet;
    private Set<Textbook> textbooks;
    private Set<Educator> educators;
    private Set<Secretary> secretary;

    private School() {
    }

    private School(Builder builder){

        this.schoolCode = builder.schoolCode;
        this.schoolName = builder.schoolName;
        this.schoolContactNumber = builder.schoolContactNumber;
        this.schoolAddress = builder.schoolAddress;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolContactNumber() {
        return schoolContactNumber;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public static class Builder {

        private String schoolCode;
        private String schoolName, schoolContactNumber, schoolAddress;
        private Set<Building> buildings;
        private Set<Stationery> stationerySet;
        private Set<Textbook> textbooks;
        private Set<Educator> educators;
        private Set<Secretary> secretary;

        public Builder schoolCode(String schoolCode)
        {
            this.schoolCode = schoolCode;
            return this;
        }

        public Builder schoolName(String schoolName)
        {
            this.schoolName = schoolName;
            return this;
        }


        public Builder schoolContactNumber(String schoolContactNumber)
        {
            this.schoolContactNumber = schoolContactNumber;
            return this;
        }

        public Builder schoolAddress(String schoolAddress)
        {
            this.schoolAddress = schoolAddress;
            return this;
        }

        public School build() {
            return new School (this);
        }

    }


}