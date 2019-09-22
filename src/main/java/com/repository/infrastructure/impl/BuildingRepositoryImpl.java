package com.repository.infrastructure.impl;

import com.domain.infrastructure.Building;
import org.springframework.stereotype.Repository;
import com.repository.infrastructure.BuildingRepository;

import java.util.*;

@Repository("InMemory")
public class BuildingRepositoryImpl implements BuildingRepository {

    private static BuildingRepositoryImpl repository = null;
    private Map<String, Building> buildings;

    private BuildingRepositoryImpl() {
        this.buildings = new HashMap<>();
    }

    public static BuildingRepositoryImpl getRepository() {
        if (repository == null) repository = new BuildingRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Building> getAll() {
        Collection<Building> buildings = this.buildings.values();
        Set<Building> set = new HashSet<>();
        set.addAll(buildings);
        return set;
    }

    @Override
    public Building create(Building building) {
        if (read(building.getBuildingNumber()) == null) {
            this.buildings.put(building.getBuildingNumber(), building);
        }
        return building;
    }

    @Override
    public Building read(String e) {
        return this.buildings.get(e);
    }

    @Override
    public Building update(Building building) {
        if (read(building.getBuildingNumber()) != null) {
            buildings.replace(building.getBuildingNumber(), building);
        }
        return building;
    }

    @Override
    public void delete(String e) {
        Building building = read(e);
        this.buildings.remove(e, building);
    }

}