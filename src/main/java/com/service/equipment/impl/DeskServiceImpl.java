package com.service.equipment.impl;

import com.domain.equipment.Desk;
import com.service.equipment.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.DeskRepository;
import com.repository.equipment.impl.DeskRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class DeskServiceImpl implements DeskService {
    @Autowired
    @Qualifier("InMemory")
    private DeskServiceImpl service = null;
    private DeskRepository repository;

    private DeskServiceImpl(){
        this.repository = DeskRepositoryImpl.getRepository();
    }

    public DeskService getService(){
        if (service == null) service = new DeskServiceImpl();
        return service;
    }

    @Override
    public Desk create(Desk desk) {
        return this.repository.create(desk);
    }

    @Override
    public Desk update(Desk desk) {
        return this.repository.update(desk);
    }

    @Override
    public void delete(String deskNumber) {
        this.repository.delete(deskNumber);
    }

    @Override
    public Desk read(String deskNumber) {
        return this.repository.read(deskNumber);
    }

    @Override
    public Set<Desk> getAll() {
        return this.repository.getAll();
    }

}
