package com.service.infrastructure.impl;

import com.domain.infrastructure.Building;
import com.service.infrastructure.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.infrastructure.BuildingRepository;
import com.repository.infrastructure.impl.BuildingRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    @Qualifier("InMemory")
    private BuildingServiceImpl service = null;
    private BuildingRepository repository;

    private BuildingServiceImpl(){
        this.repository = BuildingRepositoryImpl.getRepository();
    }

    public BuildingService getService(){
        if (service == null) service = new BuildingServiceImpl();
        return service;
    }

    @Override
    public Building create(Building building) {
        return this.repository.create(building);
    }

    @Override
    public Building update(Building building) {
        return this.repository.update(building);
    }

    @Override
    public void delete(String buildingNumber) {
        this.repository.delete(buildingNumber);
    }

    @Override
    public Building read(String buildingNumber) {
        return this.repository.read(buildingNumber);
    }

    @Override
    public Set<Building> getAll() {
        return this.repository.getAll();
    }

}
