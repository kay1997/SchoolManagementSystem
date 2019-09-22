package com.repository.assessments.impl;

import com.domain.assessments.Test;
import com.repository.assessments.TestRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class TestRepositoryImpl implements TestRepository {

    private static TestRepositoryImpl repository = null;
    private Map<String, Test> tests;

    private TestRepositoryImpl() {
        this.tests = new HashMap<>();
    }

    public static TestRepositoryImpl getRepository() {
        if (repository == null) repository = new TestRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Test> getAll() {
        Collection<Test> tests = this.tests.values();
        Set<Test> set = new HashSet<>();
        set.addAll(tests);
        return set;
    }

    @Override
    public Test create(Test test) {
        if (read(test.getTestPaperNumber()) == null) {
            this.tests.put(test.getTestPaperNumber(), test);
        }
        return test;
    }

    @Override
    public Test read(String e) {
        return this.tests.get(e);
    }

    @Override
    public Test update(Test test) {
        if (read(test.getTestPaperNumber()) != null) {
            tests.replace(test.getTestPaperNumber(), test);
        }
        return test;
    }

    @Override
    public void delete(String e) {
        Test test = read(e);
        this.tests.remove(e, test);
    }

}