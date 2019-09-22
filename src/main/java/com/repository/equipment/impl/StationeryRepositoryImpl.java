package com.repository.equipment.impl;

import com.domain.equipment.Stationery;
import com.repository.equipment.StationeryRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class StationeryRepositoryImpl implements StationeryRepository {

    private static StationeryRepositoryImpl repository = null;
    private Map<String, Stationery> stationerySet;

    private StationeryRepositoryImpl() {
        this.stationerySet = new HashMap<>();
    }

    public static StationeryRepositoryImpl getRepository() {
        if (repository == null) repository = new StationeryRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Stationery> getAll() {
        Collection<Stationery> stationerySet = this.stationerySet.values();
        Set<Stationery> set = new HashSet<>();
        set.addAll(stationerySet);
        return set;
    }

    @Override
    public Stationery create(Stationery stationery) {
        if (read(stationery.getStationeryCode()) == null) {
            this.stationerySet.put(stationery.getStationeryCode(), stationery);
        }
        return stationery;
    }

    @Override
    public Stationery read(String e) {
        return this.stationerySet.get(e);
    }

    @Override
    public Stationery update(Stationery stationery) {
        if (read(stationery.getStationeryCode()) != null) {
            stationerySet.replace(stationery.getStationeryCode(), stationery);
        }
        return stationery;
    }

    @Override
    public void delete(String e) {
        Stationery stationery = read(e);
        this.stationerySet.remove(e, stationery);
    }

}