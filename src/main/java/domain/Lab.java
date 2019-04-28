package domain;

import java.util.Set;

public class Lab {

    private String labNumber;
    private String labType;
    private Set<Computer> computers;
    private Set<Projector> projectors;
    private Set<Printer> printers;

    private Lab(){}

    private Lab(Builder builder)
    {
        this.labNumber = builder.labNumber;
        this.labType = builder.labType;
    }

    public String getLabNumber()
        {
        return labNumber;
    }

    public String getLabType()
        { return labType;
        }


    public static class Builder {

        private String labNumber;
        private String labType;
        private Set<Computer> computers;
        private Set<Projector> projectors;
        private Set<Printer> printers;

        public Builder labNumber(String labNumber)
        {
            this.labNumber = labNumber;
            return this;
        }

        public Builder labType(String labType)
        {
            this.labNumber = labNumber;
            return this;
        }

        public Lab build() {
            return new Lab(this);
        }

    }

}
