package domain;

public class Chair {

    private String chairNumber;

    private Chair(){}

    private Chair(Builder builder){
        this.chairNumber = builder.chairNumber;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public static class Builder{

        private String chairNumber;

        public Builder chairNumber(String chairNumber)
        {
            this.chairNumber = chairNumber;
            return this;
        }

        public Chair build()
        {
            return new Chair(this);
        }
    }
}
