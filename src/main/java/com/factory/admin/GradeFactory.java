package com.factory.admin;

import com.domain.admin.Grade;

public class GradeFactory {

    public static Grade getGrade(String gradeNumber)
    {
        return new Grade.Builder().gradeNumber(gradeNumber).build();
    }
}
