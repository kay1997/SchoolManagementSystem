package domain.infrastructure;

import domain.equipment.Computer;
import domain.equipment.Printer;
import domain.equipment.Projector;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
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

        public Builder copy(Lab lab){
            this.labNumber = lab.labNumber;
            this.labType = lab.labType;

            return this;
        }

        public Lab build() {
            return new Lab(this);
        }

    }


    @Override
    public String toString() {
        return "Lab{" +
                "labNumber" + labNumber + '\'' +
                "labType" + labType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab lab = (Lab) o;
        return labNumber.equals(lab.labNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labNumber);
    }
}

