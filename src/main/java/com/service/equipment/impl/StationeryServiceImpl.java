package com.service.equipment.impl;

import com.domain.equipment.Stationery;
import com.service.equipment.StationeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.StationeryRepository;
import com.repository.equipment.impl.StationeryRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class StationeryServiceImpl implements StationeryService {
    private static StationeryServiceImpl service;
    private StationeryRepository repository;

    private StationeryServiceImpl(){this.repository = StationeryRepositoryImpl.getRepository();}

    public static StationeryServiceImpl getService()
    {
        if(service == null){service = new StationeryServiceImpl();}
        return service;
    }

    @Override
    public Stationery create(Stationery stationery){
        return this.repository.create(stationery);
    }

    @Override
    public Stationery update(Stationery stationery) {
        return this.repository.update(stationery);
    }

    @Override
    public void delete(String stationeryCode){
        this.repository.delete(stationeryCode);
    }

    @Override
    public Stationery read(String stationeryCode) {
        return this.repository.read(stationeryCode);
    }

    @Override
    public Set<Stationery> getAll() {
        return this.repository.getAll();
    }

}