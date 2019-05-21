package com.domain.people;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Security {

    private String securityIDNumber, securityFirstName, securityLastName, securityAddress, securityContactNumber, securityDateOfBirth;
    private int securityAge;

    private Security(){}

    private Security(Builder builder)
    {
        this.securityFirstName = builder.securityFirstName;
        this.securityLastName = builder.securityLastName;
        this.securityAddress = builder.securityAddress;
        this.securityContactNumber = builder.securityContactNumber;
        this.securityDateOfBirth = builder.securityDateOfBirth;
        this.securityIDNumber = builder.securityIDNumber;
        this.securityAge = builder.securityAge;
    }

    public String getSecurityIDNumber() {
        return securityIDNumber;
    }
    public int getSecurityAge() {
        return securityAge;
    }

    public String getSecurityFirstName() {
        return securityFirstName;
    }

    public String getSecurityLastName() {
        return securityLastName;
    }

    public String getSecurityDateOfBirth() {
        return securityDateOfBirth;
    }

    public String getSecurityAddress() {
        return securityAddress;
    }

    public String getSecurityContactNumber() {
        return securityContactNumber;
    }

    public static class Builder {

        private String securityIDNumber, securityFirstName, securityLastName, securityAddress, securityContactNumber, securityDateOfBirth;
        private int securityAge;

        public Builder securityFirstName(String securityFirstName)
        {
            this.securityFirstName = securityFirstName;
            return this;
        }

        public Builder securityLastName(String securityLastName) {

            this.securityLastName = securityLastName;
            return this;
        }

        public Builder securityAddress(String securityAddress)
        {
            this.securityAddress = securityAddress;
            return this;
        }

        public Builder securityContactNumber(String securityContactNumber) {

            this.securityContactNumber = securityContactNumber;
            return this;
        }

        public Builder securityDateOfBirth(String securityDateOfBirth)
        {
            this.securityDateOfBirth = securityDateOfBirth;
            return this;
        }

            public Builder securityIDNumber(String securityIDNumber) {

            this.securityIDNumber = securityIDNumber;
            return this;
        }

        public Builder securityAge(int securityAge) {

            this.securityAge = securityAge;
            return this;
        }

        public Builder copy(Security security){
            this.securityIDNumber = security.securityIDNumber;
            this.securityFirstName = security.securityFirstName;
            this.securityLastName = security.securityLastName;
            this.securityAddress = security.securityAddress;
            this.securityContactNumber = security.securityContactNumber;
            this.securityDateOfBirth = security.securityDateOfBirth;
            this.securityAge = security.securityAge;;

            return this;
        }

        public Security build() {
            return new Security(this);
        }

    }

    @Override
    public String toString() {
        return "Security{" +
                "securityID='" + securityIDNumber + '\'' +
                ", securityFirstName='" + securityFirstName + '\'' +
                ", securityLastName='" + securityLastName + '\'' +
                ", securityAddress='" + securityAddress + '\'' +
                ", securityDateOfBirth='" + securityDateOfBirth+ '\'' +
                ", securityContactNumber='" + securityContactNumber + '\'' +
                ", securityFirstName='" + securityAge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return securityIDNumber.equals(security.securityIDNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityIDNumber);
    }
}

