package domain;

public class Subject {

    private String subjectCode;
    private String subjectName;

    private Subject() {}

    private Subject(Builder builder)
    {
        this.subjectCode = builder.subjectCode;
        this.subjectName = builder.subjectName;
    }

    public String getSubjectCode()
    {
        return subjectCode;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public static class Builder {

        private String subjectCode;
        private String subjectName;

        public Builder subjectCode(String subjectCode)
        {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder subjectName(String subjectName)
        {
            this.subjectName = subjectName;
            return this;
        }

        public Subject build()
        {
            return new Subject(this);
        }
    }



}
