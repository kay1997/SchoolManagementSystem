package domain.people;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Caretaker {

    private String caretakerIDNumber, caretakerFirstName, caretakerLastName, caretakerContactNumber, caretakerAddress, caretakerDateOfBirth;
    private int caretakerAge;

    public Caretaker(){}

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

    public String getCaretakerAddress() {
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

        public Builder copy(Caretaker caretaker){
            this.caretakerIDNumber = caretaker.caretakerIDNumber;
            this.caretakerFirstName = caretaker.caretakerFirstName;
            this.caretakerLastName = caretaker.caretakerLastName;
            this.caretakerLastName = caretaker.caretakerLastName;
            this.caretakerAddress = caretaker.caretakerAddress;
            this.caretakerDateOfBirth = caretaker.caretakerDateOfBirth;
            this.caretakerAge = caretaker.caretakerAge;;

            return this;
        }

        public Caretaker build() {
            return new Caretaker(this);
        }

    }

    @Override
    public String toString() {
        return "Caretaker{" +
                "caretakerID='" + caretakerIDNumber + '\'' +
                ", caretakerFirstName='" + caretakerFirstName + '\'' +
                ", caretakerLastName='" + caretakerLastName + '\'' +
                ", caretakerAddress='" + caretakerAddress + '\'' +
                ", caretakerDateOfBirth='" + caretakerDateOfBirth+ '\'' +
                ", caretakerContactNumber='" + caretakerContactNumber + '\'' +
                ", caretakerFirstName='" + caretakerAge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caretaker caretaker = (Caretaker) o;
        return caretakerIDNumber.equals(caretaker.caretakerIDNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caretakerIDNumber);
    }
}

