package com.service.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Grade;
import com.factory.admin.GradeFactory;
import com.service.admin.impl.GradeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.GradeRepository;
import com.repository.admin.impl.GradeRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class GradeServiceTest {


    GradeServiceImpl service;
    Grade grade;

    @Before
    public void setUp() throws Exception {
        service = GradeServiceImpl.getService();
        grade = GradeFactory.getGrade("1", "Senior");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(grade);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(grade);
        assertNotNull(service.read("1"));
        System.out.println("Created\n" + service.read("1"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("1"));
        System.out.println("Read\n" + service.read("1"));
    }

    @Test
    public void update() {
        service.create(grade);
        System.out.println(service.read("1"));

        Grade gradeUpdated = GradeFactory.getGrade("1", "Foundation");
        service.update(gradeUpdated);

        Grade gr = service.read("1");
        Assert.assertNotEquals(grade.getGradeType(), gr.getGradeType());
        System.out.println("Updated\n" + service.read("3"));
    }

    @Test
    public void delete() {
        service.delete(grade.getGradeID());
        assertNull(service.read(grade.getGradeID()));
        System.out.println("Delete\n" + service.read(grade.getGradeID()));
    }

}