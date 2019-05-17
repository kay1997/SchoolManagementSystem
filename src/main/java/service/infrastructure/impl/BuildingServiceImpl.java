package service.infrastructure.impl;

import domain.infrastructure.Building;
import org.springframework.stereotype.Service;
import repository.infrastructure.BuildingRepository;
import repository.infrastructure.impl.BuildingRepositoryImpl;
import service.infrastructure.BuildingService;

import java.util.Set;

@Service
public class BuildingServiceImpl implements BuildingService {

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
