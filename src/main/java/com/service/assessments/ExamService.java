package com.service.assessments;

import com.domain.assessments.Exam;
import com.service.IService;

import java.util.Set;

public interface ExamService  extends IService<Exam, String> {

    Set<Exam> getAll();

}
