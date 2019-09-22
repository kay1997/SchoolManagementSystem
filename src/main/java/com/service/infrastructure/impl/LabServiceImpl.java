package com.service.infrastructure.impl;

import com.domain.infrastructure.Lab;
import com.service.infrastructure.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.infrastructure.LabRepository;
import com.repository.infrastructure.impl.LabRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class LabServiceImpl implements LabService {
    private static LabServiceImpl service;
    private LabRepository repository;

    private LabServiceImpl(){this.repository = LabRepositoryImpl.getRepository();}

    public static LabServiceImpl getService()
    {
        if(service == null){service = new LabServiceImpl();}
        return service;
    }

    @Override
    public Lab create(Lab lab){
        return this.repository.create(lab);
    }

    @Override
    public Lab update(Lab lab) {
        return this.repository.update(lab);
    }

    @Override
    public void delete(String labNumber){
        this.repository.delete(labNumber);
    }

    @Override
    public Lab read(String labNumber) {
        return this.repository.read(labNumber);
    }

    @Override
    public Set<Lab> getAll() {
        return this.repository.getAll();
    }

}
