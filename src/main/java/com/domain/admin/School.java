package com.domain.admin;

import com.domain.infrastructure.Building;
import com.domain.equipment.Stationery;
import com.domain.equipment.Textbook;
import com.domain.people.Educator;
import com.domain.people.Secretary;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
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

        public Builder copy(School school){
            this.schoolCode = school.schoolCode;
            this.schoolName = school.schoolName;
            this.schoolAddress = school.schoolAddress;
            this.schoolContactNumber = school.schoolContactNumber;

            return this;
        }


        public School build() {
            return new School (this);
        }

    }

    @Override
    public String toString() {
        return "School {" +
                "schoolCode" + schoolCode + '\'' +
                "schoolName" + schoolName + '\'' +
                "schoolAddress" + schoolAddress + '\'' +
                "schoolContactNumber" + schoolContactNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return schoolCode.equals(school.schoolCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolCode);
    }


}