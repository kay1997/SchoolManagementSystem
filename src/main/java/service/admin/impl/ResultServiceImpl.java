package service.admin.impl;

import domain.admin.Result;
import org.springframework.stereotype.Service;
import repository.admin.ResultRepository;
import repository.admin.impl.ResultRepositoryImpl;
import service.admin.ResultService;

import java.util.Set;

@Service
public class ResultServiceImpl implements ResultService {

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