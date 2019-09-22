package com.domain.people;


import com.domain.admin.Attendance;
import com.domain.admin.Result;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Learner {

    private String learnerFirstName, learnerLastName, learnerAddress, learnerId, learnerTelephoneNumber;
    private int age;
    private Set<Attendance> attend;
    private Set<Result> results;

    private Learner() {}

    private Learner(Builder builder) {
        this.learnerId = builder.learnerId;
        this.age = builder.age;
        this.learnerFirstName = builder.learnerFirstName;
        this.learnerLastName= builder.learnerLastName;
        this.learnerAddress = builder.learnerAddress;
        this.learnerTelephoneNumber = builder.learnerTelephoneNumber;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public void setLearnerFirstName(String learnerFirstName) {
        this.learnerFirstName = learnerFirstName;
    }

    public String getLearnerId()
    {
        return learnerId;
    }

    public String getLearnerFirstName() {
        return learnerFirstName;
    }

    public String getLearnerLastName() {
        return learnerLastName;
    }

    public String getLearnerAddress() {
        return learnerAddress;
    }

    public String getLearnerTelephoneNumber()
    {
        return learnerTelephoneNumber;
    }

    public int getAge()
    {
        return age;
    }

    public static class Builder {

        private String learnerFirstName, learnerLastName, learnerAddress, learnerId, learnerTelephoneNumber;
        private int age;
        private Set<Attendance> attend;
        private Set<Result> results;

        public Builder learnerId( String learnerId) {
            this.learnerId = learnerId;
            return this;
        }

        public Builder learnerFirstName( String learnerFirstName) {
            this.learnerFirstName = learnerFirstName;
            return this;
        }

        public Builder learnerLastName( String learnerLastName) {
            this.learnerLastName = learnerLastName;
            return this;
        }

        public Builder learnerAddress( String learnerAddress) {
            this.learnerAddress = learnerAddress;
            return this;
        }

        public Builder learnerTelephoneNumber( String learnerTelephoneNumber) {
            this.learnerTelephoneNumber = learnerTelephoneNumber;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Learner learner){
            this.learnerId = learner.learnerId;
            this.learnerFirstName = learner.learnerFirstName;
            this.learnerLastName = learner.learnerLastName;
            this.learnerAddress = learner.learnerAddress;
            this.learnerTelephoneNumber = learner.learnerTelephoneNumber;

            return this;
        }


        public Learner build() {
            return new Learner(this);
        }

    }

    @Override
    public String toString() {
        return "Learner{" +
                "learnerD='" + learnerId + '\'' +
                ", learnerFirstName='" + learnerFirstName + '\'' +
                ", learnerLastName='" + learnerLastName + '\'' +
                ", learnerAddress='" + learnerAddress + '\'' +
                ", learnerTelephoneNumber='" + learnerTelephoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Learner learner = (Learner) o;
        return learnerId.equals(learner.learnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(learnerId);
    }
}
