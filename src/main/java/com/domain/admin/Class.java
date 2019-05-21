package com.domain.admin;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Class {

    private String classGroup;

    private Class(Builder builder)
    {
        this.classGroup = builder.classGroup;
    }

    public Class() {

    }

    public String getClassGroup() {
        return classGroup;
    }

    public static class Builder {

        private String classGroup;

        public Builder classGroup(String classGroup)
        {
            this.classGroup = classGroup;
            return this;
        }

        public Builder copy(Class oneClass){
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
        return classGroup.equals(oneclass.classGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classGroup);
    }

    @Override
    public String toString() {
        return "Class{" +
                "classGroup:" + classGroup + "}";
    }

}