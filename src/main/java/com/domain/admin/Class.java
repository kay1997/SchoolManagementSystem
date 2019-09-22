package com.domain.admin;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Class {

    private String classID;
    private String classGroup;

    public Class(){}

    private Class(Builder builder)
    {
        this.classID = builder.classID;
        this.classGroup = builder.classGroup;
    }

    public String getClassID(){return classID;}

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public static class Builder {

        private String classID;
        private String classGroup;

        public Builder classID(String classID)
        {
            this.classID = classID;
            return this;
        }

        public Builder classGroup(String classGroup)
        {
            this.classGroup = classGroup;
            return this;
        }

        public Builder copy(Class oneClass){
            this.classID = oneClass.classID;
            this.classGroup = oneClass.classGroup;

            return this;
        }

        public Class build() {
            return new Class(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class oneclass = (Class) o;
        return classID.equals(oneclass.classID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classID);
    }

    @Override
    public String toString() {
        return "Class{" +
                "classGroup:" + classGroup + "}";
    }

}