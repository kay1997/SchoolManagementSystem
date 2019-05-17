package service.assessments.impl;

import domain.assessments.Test;
import org.springframework.stereotype.Service;
import repository.assessments.TestRepository;
import repository.assessments.impl.TestRepositoryImpl;
import service.assessments.TestService;

import java.util.Set;

@Service
public class TestServiceImpl implements TestService {

    private TestServiceImpl service = null;
    private TestRepository repository;

    private TestServiceImpl() {
        this.repository = TestRepositoryImpl.getRepository();
    }

    public TestService getService() {
        if (service == null) service = new TestServiceImpl();
        return service;
    }

    @Override
    public Test create(Test test) {
        return this.repository.create(test);
    }

    @Override
    public Test update(Test test) {
        return this.repository.update(test);
    }

    @Override
    public void delete(String testPaperNumber) {
        this.repository.delete(testPaperNumber);
    }

    @Override
    public Test read(String testPaperNumber) {
        return this.repository.read(testPaperNumber);
    }

    @Override
    public Set<Test> getAll() {
        return this.repository.getAll();
    }

}