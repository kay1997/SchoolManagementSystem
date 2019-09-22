package com.domain.admin;

import com.domain.assessments.Assignment;
import com.domain.assessments.Exam;
import com.domain.assessments.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Result {

    private String subjectMark;
    private String learnerID;
    private Set<Test> tests;
    private Set<Assignment> assignments;
    private Set<Exam> exams;

    public Result(){
    }

    private Result(Builder builder)
    {
        this.learnerID = builder.learnerID;
        this.subjectMark = builder.subjectMark;
    }

    public String getLearnerID(){return learnerID;}

    public void setLearnerID(String learnerID) {
        this.learnerID = learnerID;
    }

    public void setSubjectMark(String subjectMark) {
        this.subjectMark = subjectMark;
    }

    public String getSubjectMark() {
        return subjectMark;
    }

    public static class Builder{

        private String subjectMark;
        private String learnerID;
        private Set<Test> tests;
        private Set<Assignment> assignments;
        private Set<Exam> exams;

        public Builder learnerID (String learnerID)
        {
            this.learnerID = learnerID;
            return this;
        }
        public Builder subjectMark(String subjectMark){

            this.subjectMark = subjectMark;
            return this;
        }

        public Builder copy(Result result){
            this.learnerID = result.learnerID;
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
                "learnerID" + learnerID + '\'' +
                "subjectMark" + subjectMark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return learnerID.equals(result.learnerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectMark);
    }


}
