package domain;

import java.util.Set;

public class Grade {

    private String gradeNumber;
    private Set<Subject> subjects;
    private Set<domain.Class> classes;
    private Set<Learner> learners;

    private Grade(Builder builder) {
       this.gradeNumber = builder.gradeNumber;
    }

    public String getGradeNumber() {
        return gradeNumber;
    }

    public static class Builder {

        private String gradeNumber;
        private Set<Subject> subjects;
        private Set<domain.Class> classes;

        public Builder gradeNumber(String gradeNumber)
        {
            this.gradeNumber = gradeNumber;
            return this;
        }

        public Grade build() {
            return new Grade(this);
        }

    }

}