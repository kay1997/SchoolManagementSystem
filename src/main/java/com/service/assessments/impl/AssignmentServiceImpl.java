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
    private static AssignmentServiceImpl service;
    private AssignmentRepository repository;

    private AssignmentServiceImpl(){this.repository = AssignmentRepositoryImpl.getRepository();}

    public static AssignmentServiceImpl getService()
    {
        if(service == null){service = new AssignmentServiceImpl();}
        return service;
    }

    @Override
    public Assignment create(Assignment assingment){
        return this.repository.create(assingment);
    }

    @Override
    public Assignment update(Assignment assingment) {
        return this.repository.update(assingment);
    }

    @Override
    public void delete(String assignmentNumber){
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
