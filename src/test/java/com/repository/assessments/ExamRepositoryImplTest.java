package com.repository.assessments;

import app.SchoolManagementSystemApplication;
import com.domain.assessments.Exam;
import com.factory.assessments.ExamFactory;
import com.repository.assessments.impl.ExamRepositoryImpl;
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
public class ExamRepositoryImplTest {
    ExamRepositoryImpl repository;
    Exam exam;

    @Before
    public void setUp() throws Exception {

        repository = ExamRepositoryImpl.getRepository();
        exam = ExamFactory.getExam("002", "Written");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(exam);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(exam);
        assertNotNull(repository.read(exam.getExamPaperNumber()));
        System.out.println("Created\n" + repository.read(exam.getExamPaperNumber()));
    }

    @Test
    public void read() {

        repository.create(exam);

        Exam exams = repository.read(exam.getExamPaperNumber());

        assertEquals(exam, exams);
    }

    @Test
    public void update() {

        repository.create(exam);

        Exam updatedExam = ExamFactory.getExam("002",  "Online");

        repository.update(updatedExam);

        Assert.assertNotEquals(exam.getExamType(), updatedExam.getExamType());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}