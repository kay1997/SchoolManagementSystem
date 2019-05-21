package com.domain.people;

import com.domain.admin.Class;
import com.domain.admin.Subject;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;
@EntityScan
public class Educator {

    private String educatorIDNumber, educatorFirstName, educatorLastName, educatorContactNumber, educatorAddress, educatorDateOfBirth;
    private int educatorAge;
    private Set<Class> classes;
    private Set<Learner> learners;
    private Set<Subject> subjects;

    private Educator(){}

    private Educator(Builder builder)
    {
        this.educatorFirstName = builder.educatorFirstName;
        this.educatorLastName = builder.educatorLastName;
        this.educatorAddress = builder.educatorAddress;
        this.educatorContactNumber = builder.educatorContactNumber;
        this.educatorDateOfBirth = builder.educatorDateOfBirth;
        this.educatorIDNumber = builder.educatorIDNumber;
        this.educatorAge = builder.educatorAge;
    }

    public String getEducatorIDNumber() {
        return educatorIDNumber;
    }
    public int getEducatorAge() {
        return educatorAge;
    }

    public String getEducatorFirstName() {
        return educatorFirstName;
    }

    public String getEducatorLastName() {
        return educatorLastName;
    }

    public String getEducatorDateOfBirth() {
        return educatorDateOfBirth;
    }

    public String getEducatorAddress() {
        return educatorAddress;
    }

    public String getEducatorContactNumber() {
        return educatorContactNumber;
    }

    public static class Builder {

        private String educatorIDNumber, educatorFirstName, educatorLastName, educatorAddress, educatorContactNumber, educatorDateOfBirth;
        private int  educatorAge;
        private Set<Class> classes;
        private Set<Learner> learners;
        private Set<Subject> subjects;

        public Builder educatorFirstName(String educatorFirstName)
        {
            this.educatorFirstName = educatorFirstName;
            return this;
        }

        public Builder educatorLastName(String educatorLastName) {

            this.educatorLastName = educatorLastName;
            return this;
        }

        public Builder educatorAddress(String educatorAddress)
        {
            this.educatorAddress = educatorAddress;
            return this;
        }

        public Builder educatorContactNumber(String educatorContactNumber) {

            this.educatorContactNumber = educatorContactNumber;
            return this;
        }

        public Builder educatorDateOfBirth(String educatorDateOfBirth)
        {
            this.educatorDateOfBirth = educatorDateOfBirth;
            return this;
        }

        public Builder educatorIDNumber(String educatorIDNumber) {

            this.educatorIDNumber = educatorIDNumber;
            return this;
        }

        public Builder educatorAge(int educatorAge) {

            this.educatorAge = educatorAge;
            return this;
        }

       public Builder copy(Educator educator){
            this.educatorIDNumber = educator.educatorIDNumber;
            this.educatorFirstName = educator.educatorFirstName;
            this.educatorLastName = educator.educatorLastName;
            this.educatorAddress = educator.educatorAddress;
            this.educatorContactNumber = educator.educatorContactNumber;
            this.educatorDateOfBirth = educator.educatorDateOfBirth;
            this.educatorAge = educator.educatorAge;;

            return this;
        }

        public Educator build() {
            return new Educator(this);
        }

    }
    @Override
    public String toString() {
        return "Educator{" +
                "educatorID='" + educatorIDNumber + '\'' +
                ", educatorFirstName='" + educatorFirstName + '\'' +
                ", educatorLastName='" + educatorLastName + '\'' +
                ", educatorAddress='" + educatorAddress + '\'' +
                ", educatorDateOfBirth='" + educatorDateOfBirth+ '\'' +
                ", educatorContactNumber='" + educatorContactNumber + '\'' +
                ", educatorFirstName='" + educatorAge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Educator educator = (Educator) o;
        return educatorIDNumber.equals(educator.educatorIDNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educatorIDNumber);
    }
}
