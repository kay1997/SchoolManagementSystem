package com.service.assessments.impl;

import com.domain.assessments.Test;
import com.service.assessments.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.assessments.TestRepository;
import com.repository.assessments.impl.TestRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class TestServiceImpl implements TestService {
    @Autowired
    @Qualifier("InMemory")
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