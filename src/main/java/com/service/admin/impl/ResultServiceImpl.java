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
    private static ResultServiceImpl service;
    private ResultRepository repository;

    private ResultServiceImpl(){this.repository = ResultRepositoryImpl.getRepository();}

    public static ResultServiceImpl getService()
    {
        if(service == null){service = new ResultServiceImpl();}
        return service;
    }

    @Override
    public Result create(Result result){
        return this.repository.create(result);
    }

    @Override
    public Result update(Result result) {
        return this.repository.update(result);
    }

    @Override
    public void delete(String learnerID){
        this.repository.delete(learnerID);
    }

    @Override
    public Result read(String learnerID) {
        return this.repository.read(learnerID);
    }

    @Override
    public Set<Result> getAll() {
        return this.repository.getAll();
    }

}

