package com.repository.assessments;

import com.domain.assessments.Exam;
import com.repository.IRepository;

import java.util.Set;

public interface ExamRepository extends IRepository<Exam, String> {

    Set<Exam> getAll();
}

