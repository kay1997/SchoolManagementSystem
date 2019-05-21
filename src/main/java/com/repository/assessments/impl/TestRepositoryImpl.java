package com.repository.assessments.impl;

import com.domain.assessments.Test;
import com.repository.assessments.TestRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class TestRepositoryImpl implements TestRepository {

    private static TestRepositoryImpl repository = null;
    private Set<Test> tests;

    private TestRepositoryImpl(){
        this.tests = new HashSet<>();
    }

    private Test findTest(String testPaperNumber) {
        return this.tests.stream()
                .filter(test -> test.getTestPaperNumber().trim().equals(testPaperNumber))
                .findAny()
                .orElse(null);
    }

    public static TestRepositoryImpl getRepository(){
        if (repository == null) repository = new TestRepositoryImpl();
        return repository;
    }


    public Test create(Test test){
        this.tests.add(test);
        return test;
    }

    public Test read(String testPaperNumber){

        Test test = findTest(testPaperNumber);
        return test;
    }

    public void delete(String testPaperNumber) {
        Test test = findTest(testPaperNumber);
        if (test != null) this.tests.remove(test);

    }

    public Test update(Test test) {
        Test toDelete = findTest(test.getTestPaperNumber());
        if (toDelete != null) {
            this.tests.remove(toDelete);
            return create(test);
        }
        return null;
    }


    public Set<Test> getAll(){
        return this.tests;
    }
}
