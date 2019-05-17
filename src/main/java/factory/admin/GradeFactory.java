package factory.admin;

import domain.admin.Grade;

public class GradeFactory {

    public static Grade getGrade(String gradeNumber)
    {
        return new Grade.Builder().gradeNumber(gradeNumber).build();
    }
}
