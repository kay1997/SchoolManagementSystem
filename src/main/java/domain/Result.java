package domain;

import java.util.Set;

public class Result {

    private String subjectMark;
    private Set<Test> tests;
    private Set<Assignment> assignments;
    private Set<Exam> exams;

    private Result(Builder builder)
    {
        this.subjectMark = builder.subjectMark;
    }

    public String getSubjectMark() {
        return subjectMark;
    }

    public static class Builder{

        private String subjectMark;
        private Set<Test> tests;
        private Set<Assignment> assignments;
        private Set<Exam> exams;

        public Builder subjectMark(String subjectMark){

            this.subjectMark = subjectMark;
            return this;
        }

        public Result build()
        {
            return new Result(this);
        }
    }
}
