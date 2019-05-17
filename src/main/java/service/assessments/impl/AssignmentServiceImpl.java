package service.assessments.impl;

import domain.assessments.Assignment;
import org.springframework.stereotype.Service;
import repository.assessments.AssignmentRepository;
import repository.assessments.impl.AssignmentRepositoryImpl;
import service.assessments.AssignmentService;

import java.util.Set;

@Service
public class AssignmentServiceImpl implements AssignmentService {

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
