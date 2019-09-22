package com.domain.admin;

import com.domain.people.Learner;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Attendance {

    private String learnerID;
    private int noOfDaysAbsent;
    private String noOfDaysPresent;

    private Attendance(){}
    private Set<Class> classes;
    private Set<Learner> learners;

    private Attendance(Builder builder)
    {
        this.learnerID = builder.learnerID;
        this.noOfDaysPresent = builder.noOfDaysPresent;
        this.noOfDaysAbsent = builder.noOfDaysAbsent;
    }

    public String getLearnerID(){return learnerID;}

    public void setLearnerID(String learnerID) {
        this.learnerID = learnerID;
    }

    public void setNoOfDaysAbsent(int noOfDaysAbsent) {
        this.noOfDaysAbsent = noOfDaysAbsent;
    }

    public void setNoOfDaysPresent(String noOfDaysPresent) {
        this.noOfDaysPresent = noOfDaysPresent;
    }

    public int getNumberOfDaysAbsent() {
        return noOfDaysAbsent;
    }

    public String getNumberOfDaysPresent() {
        return noOfDaysPresent;
    }

    public static class Builder {

        private String learnerID;
        private int noOfDaysAbsent;
        private String noOfDaysPresent;
        private Set<Class> classes;
        private Set<Learner> learners;

        public Builder learnerID(String learnerID)
        {
            this.learnerID = learnerID;
            return this;
        }

        public Builder noOfDaysAbsent(int noOfDaysAbsent)
        {
            this.noOfDaysAbsent = noOfDaysAbsent;
            return this;
        }

        public Builder noOfDaysPresent(String noOfDaysPresent)
        {
            this.noOfDaysPresent = noOfDaysPresent;
            return this;
        }

        public Builder copy(Attendance attendance){
            this.learnerID = attendance.learnerID;
            this.noOfDaysPresent = attendance.noOfDaysPresent;
            this.noOfDaysAbsent = attendance.noOfDaysAbsent;

            return this;
        }

        public Attendance build()
        {
            return new Attendance(this);
        }

    }

    @Override
    public String toString() {
        return "Attendance {" +
                "learnerID" + learnerID + '\'' +
                "numberOfDaysPresent" + noOfDaysPresent + '\'' +
                "numberOfDaysAbsent" + noOfDaysAbsent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance attendance = (Attendance) o;
        return learnerID.equals(attendance.learnerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(learnerID);
    }

}
