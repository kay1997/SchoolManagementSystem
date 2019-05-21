package com.domain.assessments;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Test {

    private String testPaperNumber;
    private String testType;

    public Test() {}

    private Test(Builder builder)
    {
        this.testPaperNumber = builder.testPaperNumber;
        this.testType = builder.testType;
    }

    public String getTestPaperNumber() {
        return testPaperNumber;
    }

    public String getTestType() {
        return testType;
    }

    public static class Builder {

        private String testPaperNumber;
        private String testType;

        public Builder testPaperNumber(String testPaperNumber)
        {
            this.testPaperNumber = testPaperNumber;
            return this;
        }

        public Builder testType(String testType)
        {
            this.testType = testType;
            return this;
        }

        public Builder copy(Test test){
            this.testPaperNumber = test.testPaperNumber;
            this.testType = test.testType;

            return this;
        }

        public Test build() {

            return new Test(this);
        }
    }

    @Override
    public String toString() {
        return "Test {" +
                "testPaperNumber" + testPaperNumber + '\'' +
                "testType" + testType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return testPaperNumber.equals(test.testPaperNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testPaperNumber);
    }
}

