package domain;

public class Computer {

    private String computerNumber;
    private String computerName;

    private Computer() {}

    private Computer(Builder builder)
    {
        this.computerNumber = builder.computerNumber;
        this.computerName = builder.computerName;
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public String getComputerName() {
        return computerName;
    }

    public static class Builder {

        private String computerNumber;
        private String computerName;

        public Builder computerNumber(String computerNumber)
        {
            this.computerNumber = computerNumber;
            return this;
        }

        public Builder computerName(String computerName)
        {
            this.computerName = computerName;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }

}