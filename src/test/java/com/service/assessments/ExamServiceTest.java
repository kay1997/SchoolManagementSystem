package com.service.assessments;

import app.SchoolManagementSystemApplication;
import com.domain.assessments.Exam;
import com.factory.assessments.ExamFactory;
import com.service.assessments.impl.ExamServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.assessments.ExamRepository;
import com.repository.assessments.impl.ExamRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ExamServiceTest {

    ExamServiceImpl service;
    Exam exam;

    @Before
    public void setUp() throws Exception {
        service = ExamServiceImpl.getService();
        exam = ExamFactory.getExam("12345", "Practical");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(exam);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(exam);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @Test
    public void update() {
        service.create(exam);
        System.out.println(service.read("12345"));

        Exam examUpdated = ExamFactory.getExam("12345", "Written");
        service.update(examUpdated);

        Exam comp = service.read("12345");
        Assert.assertNotEquals(exam.getExamType(), comp.getExamType());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(exam.getExamPaperNumber()));
        System.out.println("Delete\n" + service.read(exam.getExamPaperNumber()));
    }

}