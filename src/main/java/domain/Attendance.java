package domain;

import java.util.Set;

public class Attendance {

    private int numberOfDaysAbsent;
    private String numberOfDaysPresent;

    private Attendance(){}
    private Set<domain.Class> classes;
    private Set<Learner> learners;

    private Attendance(Builder builder)
    {
        this.numberOfDaysAbsent = builder.noOfDaysAbsent;
        this.numberOfDaysPresent = builder.noOfDaysPresent;
    }

    public int getNumberOfDaysAbsent() {
        return numberOfDaysAbsent;
    }


    public String getNumberOfDaysPresent() {
        return numberOfDaysPresent;
    }

    public static class Builder {

        private int noOfDaysAbsent;
        private String noOfDaysPresent;
        private Set<domain.Class> classes;
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

        public Attendance build()
        {
            return new Attendance(this);
        }


    }
}
