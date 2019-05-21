package com.factory.assessments;

import org.junit.Assert;
import org.junit.Test;
import com.domain.assessments.Exam;

public class ExamFactoryTest {

    @Test
    public void getExamPaperNumber() {

        String id = "2";
        String type = "Written";

        Exam exam = ExamFactory.getExam(id, type);
        System.out.println(exam);
        Assert.assertNotNull(exam.getExamPaperNumber());
    }
}
