package com.service.people.impl;


import com.domain.people.Caretaker;
import com.service.people.CaretakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.people.CaretakerRepository;
import com.repository.people.impl.CaretakerRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class CaretakerServiceImpl implements CaretakerService {
    private static CaretakerServiceImpl service;
    private CaretakerRepository repository;

    private CaretakerServiceImpl(){this.repository = CaretakerRepositoryImpl.getRepository();}

    public static CaretakerServiceImpl getService()
    {
        if(service == null){service = new CaretakerServiceImpl();}
        return service;
    }

    @Override
    public Caretaker create(Caretaker caretaker){
        return this.repository.create(caretaker);
    }

    @Override
    public Caretaker update(Caretaker caretaker) {
        return this.repository.update(caretaker);
    }

    @Override
    public void delete(String caretakerIDNumber){
        this.repository.delete(caretakerIDNumber);
    }

    @Override
    public Caretaker read(String caretakerIDNumber) {
        return this.repository.read(caretakerIDNumber);
    }

    @Override
    public Set<Caretaker> getAll() {
        return this.repository.getAll();
    }

}