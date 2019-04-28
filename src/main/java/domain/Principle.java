package domain;

import java.util.Set;

public class Principle {

    private String principleFirstName, principleLastName, principleContactNumber, principleAddress, principleDateOfBirth, principleIDNumber;
    private int principleAge;
    private Set<School> school;


    private Principle(){}

    private Principle(Builder builder)
    {
        this.principleFirstName = builder.principleFirstName;
        this.principleLastName = builder.principleLastName;
        this.principleAddress = builder.principleAddress;
        this.principleContactNumber = builder.principleContactNumber;
        this.principleDateOfBirth = builder.principleDateOfBirth;
        this.principleIDNumber = builder.principleIDNumber;
        this.principleAge = builder.principleAge;
    }

    public String getPrincipleIDNumber() {
        return principleIDNumber;
    }
    public int getPrincipleAge() {
        return principleAge;
    }

    public String getPrincipleFirstName() {
        return principleFirstName;
    }

    public String getPrincipleLastName() {
        return principleLastName;
    }

    public String getPrincipleDateOfBirth() {
        return principleDateOfBirth;
    }

    public String getPrincipleAddress() {
        return principleAddress;
    }

    public String getPrincipleContactNumber() {
        return principleContactNumber;
    }

    public static class Builder {

        private String principleFirstName, principleLastName, principleContactNumber, principleAddress, principleDateOfBirth, principleIDNumber;
        private int principleAge;
        private Set<School> school;

        public Builder principleFirstName(String principleFirstName)
        {
            this.principleFirstName = principleFirstName;
            return this;
        }

        public Builder principleLastName(String principleLastName) {

            this.principleLastName = principleLastName;
            return this;
        }

        public Builder principleAddress(String principleAddress)
        {
            this.principleAddress = principleAddress;
            return this;
        }

        public Builder principleContactNumber(String principleContactNumber) {

            this.principleContactNumber = principleContactNumber;
            return this;
        }

        public Builder principleDateOfBirth(String principleDateOfBirth)
        {
            this.principleDateOfBirth = principleDateOfBirth;
            return this;
        }

        public Builder principleIDNumber(String principleIDNumber) {

            this.principleIDNumber = principleIDNumber;
            return this;
        }

        public Builder principleAge(int principleAge) {

            this.principleAge = principleAge;
            return this;
        }

        public Principle build() {
            return new Principle(this);
        }

    }
}


