package domain;

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

        public Projector build() {
            return new Projector(this);
        }

    }
}
