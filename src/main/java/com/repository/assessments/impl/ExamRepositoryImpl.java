package com.repository.assessments.impl;

import com.domain.assessments.Exam;
import com.repository.assessments.ExamRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class ExamRepositoryImpl implements ExamRepository {

    private static ExamRepositoryImpl repository = null;
    private Set<Exam> exams;

    private ExamRepositoryImpl(){
        this.exams = new HashSet<>();
    }

    private Exam findExam(String examPaperNumber) {
        return this.exams.stream()
                .filter(exam -> exam.getExamPaperNumber().trim().equals(examPaperNumber))
                .findAny()
                .orElse(null);
    }

    public static ExamRepositoryImpl getRepository(){
        if (repository == null) repository = new ExamRepositoryImpl();
        return repository;
    }


    public Exam create(Exam exam){
        this.exams.add(exam);
        return exam;
    }

    public Exam read(String examPaperNumber){

        Exam exam = findExam(examPaperNumber);
        return exam;
    }

    public void delete(String examPaperNumber) {
        Exam exam = findExam(examPaperNumber);
        if (exam != null) this.exams.remove(exam);

    }

    public Exam update(Exam exam) {
        Exam toDelete = findExam(exam.getExamPaperNumber());
        if (toDelete != null) {
            this.exams.remove(toDelete);
            return create(exam);
        }
        return null;
    }


    public Set<Exam> getAll(){
        return this.exams;
    }
}

