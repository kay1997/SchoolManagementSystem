package com.repository.infrastructure.impl;

import com.domain.infrastructure.Building;
import org.springframework.stereotype.Repository;
import com.repository.infrastructure.BuildingRepository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class BuildingRepositoryImpl implements BuildingRepository {

    private static BuildingRepositoryImpl repository = null;
    private Set<Building> buildings;

    private BuildingRepositoryImpl(){
        this.buildings = new HashSet<>();
    }

    public static BuildingRepositoryImpl getRepository(){
        if (repository == null) repository = new BuildingRepositoryImpl();
        return repository;
    }


    public Building create(Building building){
        this.buildings.add(building);
        return building;
    }

    private Building findBuilding(String buildingNumber) {
        return this.buildings.stream()
                .filter(building -> building.getBuildingNumber().trim().equals(buildingNumber))
                .findAny()
                .orElse(null);
    }

    public Building read(String buildingNumber){

        Building building = findBuilding(buildingNumber);
        return building;
    }

    public void delete(String buildingNumber) {
        Building building = findBuilding(buildingNumber);
        if (building != null) this.buildings.remove(building);

    }

    public Building update(Building building) {
        Building toDelete = findBuilding(building.getBuildingNumber());
        if (toDelete != null) {
            this.buildings.remove(toDelete);
            return create(building);
        }
        return null;
    }

    public Set<Building> getAll(){
        return this.buildings;
    }
}
