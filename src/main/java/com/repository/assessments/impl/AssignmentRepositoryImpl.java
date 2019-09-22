package com.repository.assessments.impl;

import com.domain.assessments.Assignment;
import com.repository.assessments.AssignmentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private static AssignmentRepositoryImpl repository = null;
    private Map<String, Assignment> assignments;

    private AssignmentRepositoryImpl() {
        this.assignments = new HashMap<>();
    }

    public static AssignmentRepositoryImpl getRepository() {
        if (repository == null) repository = new AssignmentRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Assignment> getAll() {
        Collection<Assignment> assignments = this.assignments.values();
        Set<Assignment> set = new HashSet<>();
        set.addAll(assignments);
        return set;
    }

    @Override
    public Assignment create(Assignment assignment) {
        if (read(assignment.getAssignmentNumber()) == null) {
            this.assignments.put(assignment.getAssignmentNumber(), assignment);
        }
        return assignment;
    }

    @Override
    public Assignment read(String e) {
        return this.assignments.get(e);
    }

    @Override
    public Assignment update(Assignment assignment) {
        if (read(assignment.getAssignmentNumber()) != null) {
            assignments.replace(assignment.getAssignmentNumber(), assignment);
        }
        return assignment;
    }

    @Override
    public void delete(String e) {
        Assignment assignment = read(e);
        this.assignments.remove(e, assignment);
    }

}