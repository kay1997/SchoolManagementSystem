package com.domain.equipment;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Printer {

    private String printerCode;
    private String printerName;

    private Printer() {}

    private Printer(Builder builder)
    {
        this.printerCode = builder. printerCode;
        this.printerName = builder.printerName;
    }

    public String getPrinterCode() {
        return printerCode;
    }

    public String getPrinterName() {
        return printerName;
    }

    public static class Builder {

        private String printerCode;
        private String printerName;

        public Builder printerCode(String printerCode)
        {
            this.printerCode = printerCode;
            return this;
        }

        public Builder printerName(String printerName)
        {
            this.printerName = printerName;
            return this;
        }


        public Builder copy(Printer printer){
            this.printerCode = printer.printerCode;
            this.printerName = printer.printerName;

            return this;
        }

        public Printer build() {
            return new Printer(this);
        }

    }

    @Override
    public String toString() {
        return "Printer {" +
                "printerCode" + printerCode + '\'' +
                "printerName" + printerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return printerCode.equals(printer.printerCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printerCode);
    }


}
