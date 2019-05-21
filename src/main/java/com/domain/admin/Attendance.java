package com.domain.admin;

import com.domain.people.Learner;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Attendance {

    private int noOfDaysAbsent;
    private String noOfDaysPresent;

    private Attendance(){}
    private Set<Class> classes;
    private Set<Learner> learners;

    private Attendance(Builder builder)
    {
        this.noOfDaysPresent = builder.noOfDaysPresent;
        this.noOfDaysAbsent = builder.noOfDaysAbsent;
    }

    public int getNumberOfDaysAbsent() {
        return noOfDaysAbsent;
    }


    public String getNumberOfDaysPresent() {
        return noOfDaysPresent;
    }

    public static class Builder {

        private int noOfDaysAbsent;
        private String noOfDaysPresent;
        private Set<Class> classes;
        private Set<Learner> learners;

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
                "numberOfDaysPresent" + noOfDaysPresent + '\'' +
                "numberOfDaysAbsent" + noOfDaysAbsent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance attendance = (Attendance) o;
        return noOfDaysPresent.equals(attendance.noOfDaysPresent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfDaysPresent);
    }

}
