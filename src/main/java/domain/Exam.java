package domain;

public class Exam {

    private String examPaperNumber;
    private String examType;

    private Exam() {}

    private Exam(Builder builder)
    {
        this.examPaperNumber = builder.examPaperNumber;
        this.examType = builder.examType;
    }

    public String getExamPaperNumber() {
        return examPaperNumber;
    }

    public String getExamType() {
        return examType;
    }

    public static  class Builder {

        private String examPaperNumber;
        private String examType;

        public Builder examPaperNumber(String examPaperNumber)
        {
            this.examPaperNumber = examPaperNumber;
            return this;
        }

        public Builder examType(String examType)
        {
            this.examType = examType;
            return this;
        }

        public  Exam build() {

            return new Exam(this);
        }
    }
}
