package com.repository.assessments;

import com.domain.assessments.Assignment;
import com.repository.IRepository;

import java.util.Set;

public interface AssignmentRepository extends IRepository<Assignment, String> {

    Set<Assignment> getAll();
}

