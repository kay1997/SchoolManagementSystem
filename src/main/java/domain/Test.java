package domain;

public class Test {

    private String testPaperNumber;
    private String testType;

    private Test() {}

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

        public Test build() {

            return new Test(this);
        }
    }
}

