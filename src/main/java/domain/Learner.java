package domain;


import java.util.Set;

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

        public Learner build() {
            return new Learner(this);
        }

    }

@Override
    public String toString()
    {
        return "Learner{" +
                "LearnerId='" + learnerId+ '\'' +
                ", LearnerFirstName='" + learnerFirstName + '\'' +
                ", learnerLastName='" + learnerLastName + '\'' +
                ", age=" + age + '\'' +
                ", LearnerAddress=" + learnerAddress + '\'' +
                ", LearnerIDNumber='" + learnerTelephoneNumber +
                '}';

    }

}
