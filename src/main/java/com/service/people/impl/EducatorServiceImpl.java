package com.service.people.impl;

import com.domain.people.Educator;
import com.service.people.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.people.EducatorRepository;
import com.repository.people.impl.EducatorRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class EducatorServiceImpl implements EducatorService {
    private static EducatorServiceImpl service;
    private EducatorRepository repository;

    private EducatorServiceImpl(){this.repository = EducatorRepositoryImpl.getRepository();}

    public static EducatorServiceImpl getService()
    {
        if(service == null){service = new EducatorServiceImpl();}
        return service;
    }

    @Override
    public Educator create(Educator educator){
        return this.repository.create(educator);
    }

    @Override
    public Educator update(Educator educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String educatorIDNumber){
        this.repository.delete(educatorIDNumber);
    }

    @Override
    public Educator read(String educatorIDNumber) {
        return this.repository.read(educatorIDNumber);
    }

    @Override
    public Set<Educator> getAll() {
        return this.repository.getAll();
    }

}
