package domain;

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

        public Security build() {
            return new Security(this);
        }

    }
}

