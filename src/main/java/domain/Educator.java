package domain;

import java.util.Set;

public class Educator {

    private String educatorIDNumber, educatorFirstName, educatorLastName, educatorContactNumber, educatorAddress, educatorDateOfBirth;
    private int educatorAge;
    private Set<domain.Class> classes;
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
        private Set<domain.Class> classes;
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

        public Educator build() {
            return new Educator(this);
        }

    }
}