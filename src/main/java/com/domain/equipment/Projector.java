package com.domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Projector {

    private String projectorCode;
    private String projectorName;

    private Projector() {}

    private Projector(Builder builder)
    {
        this.projectorCode = builder. projectorCode;
        this.projectorName = builder.projectorName;
    }

    public String getProjectorCode() {
        return projectorCode;
    }

    public void setProjectorCode(String projectorCode) {
        this.projectorCode = projectorCode;
    }

    public void setProjectorName(String projectorName) {
        this.projectorName = projectorName;
    }

    public String getProjectorName() {
    return projectorName;
    }

    public static class Builder {

        private String projectorCode;
        private String projectorName;

        public Builder projectorCode(String projectorCode)
        {
            this.projectorCode = projectorCode;
            return this;
        }

        public Builder projectorName(String projectorName)
        {
            this.projectorName = projectorName;
            return this;
        }

        public Builder copy(Projector projector){
            this.projectorCode = projector.projectorCode;
            this.projectorName = projector.projectorName;

            return this;
        }

        public Projector build() {
            return new Projector(this);
        }

    }


    @Override
    public String toString() {
        return "Projector {" +
                "projectorCode" + projectorCode + '\'' +
                "projectorName" + projectorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projector projector = (Projector) o;
        return projectorCode.equals(projector.projectorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectorCode);
    }
}
