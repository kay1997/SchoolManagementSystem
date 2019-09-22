package com.repository.admin.impl;

import com.domain.admin.Result;
import com.repository.admin.ResultRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class ResultRepositoryImpl implements ResultRepository {

    private static ResultRepositoryImpl repository = null;
    private Map<String, Result> results;

    private ResultRepositoryImpl() {
        this.results = new HashMap<>();
    }

    public static ResultRepositoryImpl getRepository() {
        if (repository == null) repository = new ResultRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Result> getAll() {
        Collection<Result> results = this.results.values();
        Set<Result> set = new HashSet<>();
        set.addAll(results);
        return set;
    }

    @Override
    public Result create(Result result) {
        if (read(result.getLearnerID()) == null) {
            this.results.put(result.getLearnerID(), result);
        }
        return result;
    }

    @Override
    public Result read(String e) {
        return this.results.get(e);
    }

    @Override
    public Result update(Result result) {
        if (read(result.getLearnerID()) != null) {
            results.replace(result.getLearnerID(), result);
        }
        return result;
    }

    @Override
    public void delete(String e) {
        Result result = read(e);
        this.results.remove(e, result);
    }

}