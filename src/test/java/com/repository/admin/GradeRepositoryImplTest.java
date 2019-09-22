package com.repository.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Grade;
import com.factory.admin.GradeFactory;
import com.repository.admin.impl.GradeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class GradeRepositoryImplTest {
    GradeRepositoryImpl repository;
    Grade grade;

    @Before
    public void setUp() throws Exception {

        repository = GradeRepositoryImpl.getRepository();
        grade = GradeFactory.getGrade("3", "Senior");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(grade);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(grade);
        assertNotNull(repository.read(grade.getGradeID()));
        System.out.println("Created\n" + repository.read(grade.getGradeID()));
    }

    @Test
    public void read() {

        repository.create(grade);

        Grade grades = repository.read(grade.getGradeID());

        assertEquals(grade, grades);
    }

    @Test
    public void update() {

        repository.create(grade);

        Grade updatedGrade = GradeFactory.getGrade("3",  "Foundation");

        repository.update(updatedGrade);

        Assert.assertNotEquals(grade.getGradeType(), updatedGrade.getGradeType());
    }

    @Test
    public void delete() {
        repository.delete("3");
        assertNull(repository.read("3"));
        System.out.println("Deleted\n" + repository.read("3"));
    }

}