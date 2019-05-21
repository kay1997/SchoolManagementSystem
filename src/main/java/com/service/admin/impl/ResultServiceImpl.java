package com.service.admin.impl;

import com.domain.admin.Result;
import com.service.admin.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.admin.ResultRepository;
import com.repository.admin.impl.ResultRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class ResultServiceImpl implements ResultService {
    @Autowired
    @Qualifier("InMemory")
    private ResultServiceImpl service = null;
    private ResultRepository repository;

    private ResultServiceImpl() {
        this.repository = ResultRepositoryImpl.getRepository();
    }

    public ResultService getService() {
        if (service == null) service = new ResultServiceImpl();
        return service;
    }

    @Override
    public Result create(Result result) {
        return this.repository.create(result);
    }

    @Override
    public Result update(Result result) {
        return this.repository.update(result);
    }

    @Override
    public void delete(String subjectMark) {
        this.repository.delete(subjectMark);
    }

    @Override
    public Result read(String subjectMark) {
        return this.repository.read(subjectMark);
    }

    @Override
    public Set<Result> getAll() {
        return this.repository.getAll();
    }

}