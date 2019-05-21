package com.factory.assessments;

import com.domain.assessments.Exam;

public class ExamFactory {

    public static Exam getExam(String examPaperNumber, String examType) {
        return new Exam.Builder().examPaperNumber(examPaperNumber).examType(examType).build();
    }
}