package com.service.equipment.impl;

import com.domain.equipment.Computer;
import com.service.equipment.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.ComputerRepository;
import com.repository.equipment.impl.ComputerRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class ComputerServiceImpl implements ComputerService {
    private static ComputerServiceImpl service;
    private ComputerRepository repository;

    private ComputerServiceImpl(){this.repository = ComputerRepositoryImpl.getRepository();}

    public static ComputerServiceImpl getService()
    {
        if(service == null){service = new ComputerServiceImpl();}
        return service;
    }

    @Override
    public Computer create(Computer computer){
        return this.repository.create(computer);
    }

    @Override
    public Computer update(Computer computer) {
        return this.repository.update(computer);
    }

    @Override
    public void delete(String computerNumber){
        this.repository.delete(computerNumber);
    }

    @Override
    public Computer read(String computerNumber) {
        return this.repository.read(computerNumber);
    }

    @Override
    public Set<Computer> getAll() {
        return this.repository.getAll();
    }

}