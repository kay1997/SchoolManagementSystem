package com.repository.assessments.impl;

import com.domain.assessments.Exam;
import com.repository.assessments.ExamRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class ExamRepositoryImpl implements ExamRepository {

    private static ExamRepositoryImpl repository = null;
    private Map<String, Exam> exams;

    private ExamRepositoryImpl() {
        this.exams = new HashMap<>();
    }

    public static ExamRepositoryImpl getRepository() {
        if (repository == null) repository = new ExamRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Exam> getAll() {
        Collection<Exam> exams = this.exams.values();
        Set<Exam> set = new HashSet<>();
        set.addAll(exams);
        return set;
    }

    @Override
    public Exam create(Exam exam) {
        if (read(exam.getExamPaperNumber()) == null) {
            this.exams.put(exam.getExamPaperNumber(), exam);
        }
        return exam;
    }

    @Override
    public Exam read(String e) {
        return this.exams.get(e);
    }

    @Override
    public Exam update(Exam exam) {
        if (read(exam.getExamPaperNumber()) != null) {
            exams.replace(exam.getExamPaperNumber(), exam);
        }
        return exam;
    }

    @Override
    public void delete(String e) {
        Exam exam = read(e);
        this.exams.remove(e, exam);
    }

}