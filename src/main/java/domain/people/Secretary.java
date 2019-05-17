package domain.people;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Secretary {

    private String secretaryIDNumber, secretaryFirstName, secretaryLastName, secretaryContactNumber, secretaryAddress, secretaryDateOfBirth;
    private int secretaryAge;

    private Secretary(){}

    private Secretary(Builder builder)
    {
        this.secretaryFirstName = builder.secretaryFirstName;
        this.secretaryLastName = builder.secretaryLastName;
        this.secretaryAddress = builder.secretaryAddress;
        this.secretaryContactNumber = builder.secretaryContactNumber;
        this.secretaryDateOfBirth = builder.secretaryDateOfBirth;
        this.secretaryIDNumber = builder.secretaryIDNumber;
        this.secretaryAge = builder.secretaryAge;
    }

    public String getSecretaryIDNumber() {
        return secretaryIDNumber;
    }
    public int getSecretaryAge() {
        return secretaryAge;
    }

    public String getSecretaryFirstName() {
        return secretaryFirstName;
    }

    public String getSecretaryLastName() {
        return secretaryLastName;
    }

    public String getSecretaryDateOfBirth() {
        return secretaryDateOfBirth;
    }

    public String getSecretaryAddress() {
        return secretaryAddress;
    }

    public String getSecretaryContactNumber() {
        return secretaryContactNumber;
    }

    public static class Builder {

        private String secretaryIDNumber, secretaryFirstName, secretaryLastName, secretaryContactNumber, secretaryAddress, secretaryDateOfBirth;
        private int  secretaryAge;

        public Builder secretaryFirstName(String secretaryFirstName)
        {
            this.secretaryFirstName = secretaryFirstName;
            return this;
        }

        public Builder secretaryLastName(String secretaryLastName) {

            this.secretaryLastName = secretaryLastName;
            return this;
        }

        public Builder secretaryAddress(String secretaryAddress)
        {
            this.secretaryAddress = secretaryAddress;
            return this;
        }

        public Builder secretaryContactNumber(String secretaryContactNumber) {

            this.secretaryContactNumber = secretaryContactNumber;
            return this;
        }

        public Builder secretaryDateOfBirth(String secretaryDateOfBirth)
        {
            this.secretaryDateOfBirth = secretaryDateOfBirth;
            return this;
        }

        public Builder secretaryIDNumber(String secretaryIDNumber) {

            this.secretaryIDNumber = secretaryIDNumber;
            return this;
        }

        public Builder secretaryAge(int secretaryAge) {

            this.secretaryAge = secretaryAge;
            return this;
        }

        public Builder copy(Secretary secretary){
            this.secretaryIDNumber = secretary.secretaryIDNumber;
            this.secretaryFirstName = secretary.secretaryFirstName;
            this.secretaryLastName = secretary.secretaryLastName;
            this.secretaryAddress = secretary.secretaryAddress;
            this.secretaryContactNumber = secretary.secretaryContactNumber;
            this.secretaryDateOfBirth = secretary.secretaryDateOfBirth;
            this.secretaryAge = secretary.secretaryAge;;

            return this;
        }

        public Secretary build() {
            return new Secretary(this);
        }

    }
    @Override
    public String toString() {
        return "Secretary{" +
                "secretaryD='" + secretaryIDNumber + '\'' +
                ", secretaryFirstName='" + secretaryFirstName + '\'' +
                ", secretaryLastName='" + secretaryLastName + '\'' +
                ", secretaryAddress='" + secretaryAddress + '\'' +
                ", secretaryDateOfBirth='" + secretaryDateOfBirth+ '\'' +
                ", secretaryContactNumber='" + secretaryContactNumber + '\'' +
                ", secretaryFirstName='" + secretaryAge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secretary secretary = (Secretary) o;
        return secretaryIDNumber.equals(secretary.secretaryIDNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secretaryIDNumber);
    }
}