package com.domain.admin;

import com.domain.people.Learner;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Grade {

    private String gradeID;
    private String gradeType;
    private Set<Subject> subjects;
    private Set<Class> classes;
    private Set<Learner> learners;

    public Grade(){}

    private Grade(Builder builder) {

        this.gradeID = builder.gradeID;
        this.gradeType = builder.gradeType;
    }

    public String getGradeID(){return gradeID;}

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    public String getGradeType() {
        return gradeType;
    }

    public static class Builder {

        private String gradeID;
        private String gradeType;
        private Set<Subject> subjects;
        private Set<Class> classes;

        public Builder gradeID(String gradeID)
        {
            this.gradeID = gradeID;
            return this;
        }

        public Builder gradeType(String gradeType)
        {
            this.gradeType = gradeType;
            return this;
        }

        public Builder copy(Grade grade){
            this.gradeID = grade.gradeID;
            this.gradeType = grade.gradeType;

            return this;
        }

        public Grade build() {
            return new Grade(this);
        }

    }

    @Override
    public String toString() {
        return "Grade {" +
                "gradeID" + gradeID + '\'' +
                "gradeType" + gradeType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return gradeID.equals(grade.gradeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeID);
    }


}