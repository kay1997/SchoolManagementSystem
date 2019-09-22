package com.service.equipment.impl;

import com.domain.equipment.Chair;
import com.service.equipment.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.ChairRepository;

import com.repository.equipment.impl.ChairRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class ChairServiceImpl implements ChairService {
    private static ChairServiceImpl service;
    private ChairRepository repository;

    private ChairServiceImpl(){this.repository = ChairRepositoryImpl.getRepository();}

    public static ChairServiceImpl getService()
    {
        if(service == null){service = new ChairServiceImpl();}
        return service;
    }

    @Override
    public Chair create(Chair chair){
        return this.repository.create(chair);
    }

    @Override
    public Chair update(Chair chair) {
        return this.repository.update(chair);
    }

    @Override
    public void delete(String chairNumber){
        this.repository.delete(chairNumber);
    }

    @Override
    public Chair read(String chairNumber) {
        return this.repository.read(chairNumber);
    }

    @Override
    public Set<Chair> getAll() {
        return this.repository.getAll();
    }

}
