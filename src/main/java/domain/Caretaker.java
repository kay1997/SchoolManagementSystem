package domain;

public class Caretaker {

    private String caretakerIDNumber, caretakerFirstName, caretakerLastName, caretakerContactNumber, caretakerAddress, caretakerDateOfBirth;
    private int caretakerAge;

    private Caretaker(){}

    private Caretaker(Builder builder)
    {
        this.caretakerFirstName = builder.caretakerFirstName;
        this.caretakerLastName = builder.caretakerLastName;
        this.caretakerAddress = builder.caretakerAddress;
        this.caretakerContactNumber = builder.caretakerContactNumber;
        this.caretakerDateOfBirth = builder.caretakerDateOfBirth;
        this.caretakerIDNumber = builder.caretakerIDNumber;
        this.caretakerAge = builder.caretakerAge;
    }

    public String getCaretakerIDNumber() {
        return caretakerIDNumber;
    }
    public int getCaretakerAge() {
        return caretakerAge;
    }

    public String getCaretakerFirstName() {
        return caretakerFirstName;
    }

    public String getCaretakerLastName() {
        return caretakerLastName;
    }

    public String getCaretakerDateOfBirth() {
        return caretakerDateOfBirth;
    }

    public String educatorAddress() {
        return caretakerAddress;
    }

    public String getCaretakerContactNumber() {
        return caretakerContactNumber;
    }

    public static class Builder {

        private String caretakerIDNumber, caretakerFirstName, caretakerLastName, caretakerContactNumber, caretakerAddress, caretakerDateOfBirth;
        private int caretakerAge;


        public Builder caretakerFirstName(String caretakerFirstName)
        {
            this.caretakerFirstName = caretakerFirstName;
            return this;
        }

        public Builder caretakerLastName(String caretakerLastName) {

            this.caretakerLastName = caretakerLastName;
            return this;
        }

        public Builder caretakerAddress(String caretakerAddress)
        {
            this.caretakerAddress = caretakerAddress;
            return this;
        }

        public Builder caretakerContactNumber(String caretakerContactNumber) {

            this.caretakerContactNumber = caretakerContactNumber;
            return this;
        }

        public Builder caretakerDateOfBirth(String caretakerDateOfBirth)
        {
            this.caretakerDateOfBirth = caretakerDateOfBirth;
            return this;
        }

        public Builder caretakerIDNumber(String caretakerIDNumber) {

            this.caretakerIDNumber = caretakerIDNumber;
            return this;
        }

        public Builder caretakerAge(int caretakerAge) {

            this.caretakerAge = caretakerAge;
            return this;
        }

        public Caretaker build() {
            return new Caretaker(this);
        }

    }
}

