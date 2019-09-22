package com.service.people.impl;

import com.domain.people.Learner;
import com.service.people.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.people.LearnerRepository;
import com.repository.people.impl.LearnerRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class LearnerServiceImpl implements LearnerService {
    private static LearnerServiceImpl service;
    private LearnerRepository repository;

    private LearnerServiceImpl(){this.repository = LearnerRepositoryImpl.getRepository();}

    public static LearnerServiceImpl getService()
    {
        if(service == null){service = new LearnerServiceImpl();}
        return service;
    }

    @Override
    public Learner create(Learner learner){
        return this.repository.create(learner);
    }

    @Override
    public Learner update(Learner learner) {
        return this.repository.update(learner);
    }

    @Override
    public void delete(String learnerIDNumber){
        this.repository.delete(learnerIDNumber);
    }

    @Override
    public Learner read(String learnerIDNumber) {
        return this.repository.read(learnerIDNumber);
    }

    @Override
    public Set<Learner> getAll() {
        return this.repository.getAll();
    }

}
