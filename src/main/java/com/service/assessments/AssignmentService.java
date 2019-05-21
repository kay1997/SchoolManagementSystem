package com.service.assessments;

import com.domain.assessments.Assignment;
import com.service.IService;

import java.util.Set;

public interface AssignmentService extends IService<Assignment, String> {

    Set<Assignment> getAll();

}