package domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
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

        public Builder copy(Chair chair){
            this.chairNumber = chair.chairNumber;

            return this;
        }

        public Chair build()
        {
            return new Chair(this);
        }
    }

    @Override
    public String toString() {
        return "Chair) {" +
                "chairNumber" + chairNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return chairNumber.equals(chair.chairNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chairNumber);
    }
}
