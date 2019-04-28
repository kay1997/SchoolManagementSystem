package domain;

public class Stationery {

    private String stationeryCode;
    private String stationeryType;

    private Stationery(){}

    private Stationery(Builder builder)
    {
        this.stationeryCode = builder.stationeryCode;
        this.stationeryType = builder.stationeryType;
    }

    public String getStationeryCode() {
        return stationeryCode;
    }

    public String getStationeryType() {
        return stationeryType;
    }

    public static class Builder {

        private String stationeryCode;
        private String stationeryType;

        public Builder stationeryCode(String stationeryCode)
        {
            this.stationeryCode = stationeryCode;
            return this;
        }

        public Builder stationeryType(String stationeryType)
        {
            this.stationeryType = stationeryType;
            return this;
        }

        public Stationery build()
        {
            return new Stationery(this);
        }
    }
}
