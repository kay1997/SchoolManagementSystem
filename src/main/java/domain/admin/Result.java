package domain.admin;

import domain.assessments.Assignment;
import domain.assessments.Exam;
import domain.assessments.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
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

        public Builder copy(Result result){
            this.subjectMark = result.subjectMark;

            return this;
        }

        public Result build()
        {
            return new Result(this);
        }
    }

    @Override
    public String toString() {
        return "Result {" +
                "subjectMark" + subjectMark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return subjectMark.equals(result.subjectMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectMark);
    }


}
