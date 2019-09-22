package com.service.people.impl;

import com.domain.people.Principle;
import com.service.people.PrincipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.people.PrincipleRepository;
import com.repository.people.impl.PrincipleRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class PrincipleServiceImpl implements PrincipleService {
    private static PrincipleServiceImpl service;
    private PrincipleRepository repository;

    private PrincipleServiceImpl(){this.repository = PrincipleRepositoryImpl.getRepository();}

    public static PrincipleServiceImpl getService()
    {
        if(service == null){service = new PrincipleServiceImpl();}
        return service;
    }

    @Override
    public Principle create(Principle principle){
        return this.repository.create(principle);
    }

    @Override
    public Principle update(Principle principle) {
        return this.repository.update(principle);
    }

    @Override
    public void delete(String principleIDNumber){
        this.repository.delete(principleIDNumber);
    }

    @Override
    public Principle read(String principleIDNumber) {
        return this.repository.read(principleIDNumber);
    }

    @Override
    public Set<Principle> getAll() {
        return this.repository.getAll();
    }

}
