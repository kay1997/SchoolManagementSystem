package com.domain.assessments;

/*
 * Kaylen Abrahams
  * Student Number: 216054664
  * Group: 3G
  * */

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Assignment {

    private String assignmentNumber;
    private String assignmentType;

    private Assignment() {}

    private Assignment(Builder builder)
    {
        this.assignmentNumber = builder.assignmentNumber;
        this.assignmentType = builder.assignmentType;
    }

    public String getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(String assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public static  class Builder {

        private String assignmentNumber;
        private String assignmentType;

        public Builder assignmentNumber(String assignmentNumber)
        {
            this.assignmentNumber = assignmentNumber;
            return this;
        }

        public Builder assignmentType(String assignmentType)
        {
            this.assignmentType = assignmentType;
            return this;
        }

        public Builder copy(Assignment assignment){
            this.assignmentNumber = assignment.assignmentNumber;
            this.assignmentType = assignment.assignmentType;

            return this;
        }

        public  Assignment build() {

            return new Assignment(this);
        }
    }
    @Override
    public String toString() {
        return "Assignment {" +
                "assignmentNumber" + assignmentNumber + '\'' +
                "assignmentType" + assignmentType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment assignment = (Assignment) o;
        return assignmentNumber.equals(assignment.assignmentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentNumber);
    }

}

