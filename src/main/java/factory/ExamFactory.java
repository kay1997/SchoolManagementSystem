package factory;

import domain.Exam;

public class ExamFactory {

    public static Exam getExam(String examPaperNumber, String examType) {
        return new Exam.Builder().examPaperNumber(examPaperNumber).examType(examType).build();
    }
}