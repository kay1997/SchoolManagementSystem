package com.repository.assessments.impl;

import com.domain.assessments.Assignment;
import com.repository.assessments.AssignmentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private static AssignmentRepositoryImpl repository = null;
    private Set<Assignment> assignments;

   private AssignmentRepositoryImpl(){
        this.assignments = new HashSet<>();
    }

    private Assignment findAssignment(String assignmentNumber) {
        return this.assignments.stream()
                .filter(assignment -> assignment.getAssignmentNumber().trim().equals(assignmentNumber))
                .findAny()
                .orElse(null);
    }

    public static AssignmentRepositoryImpl getRepository(){
        if (repository == null) repository = new AssignmentRepositoryImpl();
        return repository;
    }


    public Assignment create(Assignment assignment){
        this.assignments.add(assignment);
        return assignment;
    }

    public Assignment read(String assignmentNumber){

        Assignment assignment = findAssignment(assignmentNumber);
        return assignment;
    }

    public void delete(String assignmentNumber) {
        Assignment assignment = findAssignment(assignmentNumber);
        if (assignment != null) this.assignments.remove(assignment);

    }

    public Assignment update(Assignment assignment) {
        Assignment toDelete = findAssignment(assignment.getAssignmentNumber());
        if (toDelete != null) {
            this.assignments.remove(toDelete);
            return create(assignment);
        }
        return null;
    }


    public Set<Assignment> getAll(){
        return this.assignments;
    }
}

