package com.repository.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Grade;
import com.factory.admin.GradeFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class GradeRepositoryImplTest {
    @Autowired
    private GradeRepository repository;
    private String gradeNo = null;

    @Test
    public void CreateGradeTest() throws IOException {
        Grade grade = GradeFactory.getGrade("3");
        Grade result = repository.create(grade);
        gradeNo = result.getGradeNumber();
        Assert.assertNotNull(grade);
    }

    @Test
    public void GetGradeTest() throws IOException {

        Grade grade = repository.read(gradeNo);
        Assert.assertNotNull(grade);
    }
}
