package com.repository.assessments;

import com.app.SchoolManagementSystemApplication;
import com.domain.assessments.Exam;
import com.factory.assessments.ExamFactory;
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
public class ExamRepositoryImplTest {
    @Autowired
    private ExamRepository repository;
    private String examNo = null;

    @Test
    public void CreateExamTest() throws IOException {
        Exam exam = ExamFactory.getExam("3", "Practical");
        Exam result = repository.create(exam);
        examNo = result.getExamPaperNumber();
        Assert.assertNotNull(exam);
    }

    @Test
    public void GetExamTest() throws IOException {

        Exam exam = repository.read(examNo);
        Assert.assertNotNull(exam);
    }
}
