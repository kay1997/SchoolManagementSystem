package com.service.assessments.impl;

import com.domain.assessments.Assignment;
import com.service.assessments.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.assessments.AssignmentRepository;
import com.repository.assessments.impl.AssignmentRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    @Qualifier("InMemory")
    private AssignmentServiceImpl service = null;
    private AssignmentRepository repository;

    private AssignmentServiceImpl(){
        this.repository = AssignmentRepositoryImpl.getRepository();
    }

    public AssignmentService getService(){
        if (service == null) service = new AssignmentServiceImpl();
        return service;
    }

    @Override
    public Assignment create(Assignment assignment) {
        return this.repository.create(assignment);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return this.repository.update(assignment);
    }

    @Override
    public void delete(String assignmentNumber) {
        this.repository.delete(assignmentNumber);
    }

    @Override
    public Assignment read(String assignmentNumber) {
        return this.repository.read(assignmentNumber);
    }

    @Override
    public Set<Assignment> getAll() {
        return this.repository.getAll();
    }
}
