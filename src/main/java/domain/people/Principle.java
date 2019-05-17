package domain.people;

import domain.admin.School;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Principle {

    private String principleFirstName, principleLastName, principleContactNumber, principleAddress, principleDateOfBirth, principleIDNumber;
    private int principleAge;
    private Set<School> school;


    public Principle(){}

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

        public Builder copy(Principle principle){
            this.principleIDNumber = principle.principleIDNumber;
            this.principleFirstName = principle.principleFirstName;
            this.principleLastName = principle.principleLastName;
            this.principleAddress = principle.principleAddress;
            this.principleContactNumber = principle.principleContactNumber;
            this.principleDateOfBirth = principle.principleDateOfBirth;
            this.principleAge = principle.principleAge;;

            return this;
        }


        public Principle build() {
            return new Principle(this);
        }

    }
    @Override
    public String toString() {
        return "Principle{" +
                "principleD='" + principleIDNumber + '\'' +
                ", principleFirstName='" + principleFirstName + '\'' +
                ", principleLastName='" + principleLastName + '\'' +
                ", principleAddress='" + principleAddress + '\'' +
                ", principleDateOfBirth='" + principleDateOfBirth+ '\'' +
                ", principleContactNumber='" + principleContactNumber + '\'' +
                ", principleFirstName='" + principleAge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Principle principle = (Principle) o;
        return principleIDNumber.equals(principle.principleIDNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(principleIDNumber);
    }
}


