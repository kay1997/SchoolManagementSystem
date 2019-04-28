package domain;

/*
 * Kaylen Abrahams
  * Student Number: 216054664
  * Group: 3G
  * */

public class Assignment {

    private String assignmentNumber;
    private String assignmentType;

    private Assignment() {}

    private Assignment(Builder builder)
    {
        this.assignmentNumber = builder.assignmentNumber;
        this.assignmentType = builder.assignmentType;
    }

    public String getAssignmentNumber() {
        return assignmentNumber;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public static  class Builder {

        private String assignmentNumber;
        private String assignmentType;

        public Builder assignmentNumber(String assignmentNumber)
        {
            this.assignmentNumber = assignmentNumber;
            return this;
        }

        public Builder assignmentType(String assignmentType)
        {
            this.assignmentType = assignmentType;
            return this;
        }

        public  Assignment build() {

            return new Assignment(this);
        }
    }
}

