package domain;

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

        public Printer build() {
            return new Printer(this);
        }

    }
}
