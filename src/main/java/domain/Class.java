package domain;

public class Class {

    private String classGroup;

    private Class(Builder builder)
    {
        this.classGroup = builder.classGroup;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public static class Builder {

        private String classGroup;

        public Builder classGroup(String classGroup)
        {
            this.classGroup = classGroup;
            return this;
        }

        public Class build() {
            return new Class(this);
        }

    }
}