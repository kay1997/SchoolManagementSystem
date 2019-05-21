package com.repository.admin.impl;

import com.domain.admin.Result;
import com.repository.admin.ResultRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class ResultRepositoryImpl implements ResultRepository {

    private static ResultRepositoryImpl repository = null;
    private Set<Result> results;

    private ResultRepositoryImpl(){
        this.results = new HashSet<>();
    }

    private Result findResult(String subjectMark) {
        return this.results.stream()
                .filter(result -> result.getSubjectMark().trim().equals(subjectMark))
                .findAny()
                .orElse(null);
    }

    public static ResultRepositoryImpl getRepository(){
        if (repository == null) repository = new ResultRepositoryImpl();
        return repository;
    }

        public Result create(Result result){
        this.results.add(result);
        return result;
    }

    public Result read(String subjectMark){

        Result result = findResult(subjectMark);
        return result;
    }

    public void delete(String subjectMark) {
        Result result = findResult(subjectMark);
        if (result != null) this.results.remove(subjectMark);

    }

    public Result update(Result result){
        Result toDelete = findResult(result.getSubjectMark());
        if(toDelete != null) {
            this.results.remove(toDelete);
            return create(result);
        }
        return null;
    }


    public Set<Result> getAll(){
        return this.results;
    }
}
