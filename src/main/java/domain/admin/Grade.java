package domain.admin;

import domain.people.Learner;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;

@EntityScan
public class Grade {

    private String gradeNumber;
    private Set<Subject> subjects;
    private Set<Class> classes;
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
        private Set<Class> classes;

        public Builder gradeNumber(String gradeNumber)
        {
            this.gradeNumber = gradeNumber;
            return this;
        }

        public Builder copy(Grade grade){
            this.gradeNumber = grade.gradeNumber;

            return this;
        }

        public Grade build() {
            return new Grade(this);
        }

    }

    @Override
    public String toString() {
        return "Grade {" +
                "gradeNumber" + gradeNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return gradeNumber.equals(grade.gradeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeNumber);
    }


}