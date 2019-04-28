package domain;

public class Desk {

    private String deskNumber;

    private Desk(){}

    private Desk(Builder builder)
    {
        this.deskNumber = builder.deskNumber;
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public static class Builder{

        private String deskNumber;

        public Builder deskNumber(String deskNumber){

            this.deskNumber = deskNumber;
            return this;
        }

        public Desk build()
        {
            return new Desk(this);
        }
    }
}
