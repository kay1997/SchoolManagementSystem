package com.factory.admin;

import org.junit.Assert;
import org.junit.Test;
import com.domain.admin.Grade;


public class GradeFactoryClass {

    @Test
    public void getGradeNumber() {

       String id = "5";
       String type = "Foundation";

        Grade grade = GradeFactory.getGrade(id, type);
        System.out.println(grade);
        Assert.assertNotNull(grade.getGradeID());
    }
}
