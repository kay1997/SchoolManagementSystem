package com.domain.admin;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
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

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

        public Builder copy(Subject subject){
            this.subjectCode = subject.subjectCode;
            this.subjectName = subject.subjectName;

            return this;
        }

        public Subject build()
        {
            return new Subject(this);
        }
    }

    @Override
    public String toString() {
        return "Subject {" +
                "subjectCode" + subjectCode + '\'' +
                "subjectName" + subjectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectCode.equals(subject.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
