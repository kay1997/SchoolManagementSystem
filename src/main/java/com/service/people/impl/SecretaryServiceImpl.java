package com.service.people.impl;



import com.domain.people.Secretary;
import com.service.people.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.people.SecretaryRepository;
import com.repository.people.impl.SecretaryRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class SecretaryServiceImpl implements SecretaryService {
    @Autowired
    @Qualifier("InMemory")
    private SecretaryServiceImpl service = null;
    private SecretaryRepository repository;

    private SecretaryServiceImpl(){
        this.repository = SecretaryRepositoryImpl.getRepository();
    }

    public SecretaryService getService(){
        if (service == null) service = new SecretaryServiceImpl();
        return service;
    }

    @Override
    public Secretary create(Secretary secretary) {
        return this.repository.create(secretary);
    }

    @Override
    public Secretary update(Secretary secretary) {
        return this.repository.update(secretary);
    }

    @Override
    public void delete(String secretaryIDNumber) {
        this.repository.delete(secretaryIDNumber);
    }

    @Override
    public Secretary read(String secretaryIDNumber) {
        return this.repository.read(secretaryIDNumber);
    }

    @Override
    public Set<Secretary> getAll() {
        return this.repository.getAll();
    }
}
