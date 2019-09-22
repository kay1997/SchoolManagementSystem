package com.factory.admin;

import com.domain.admin.Grade;
import com.util.Misc;

public class GradeFactory {

    public static Grade getGrade(String gradeID, String gradeType)
    {
        return new Grade.Builder().gradeID(gradeID).gradeType(gradeType).build();
    }
}
