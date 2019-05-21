package com.repository.equipment.impl;

import com.domain.equipment.Stationery;
import com.repository.equipment.StationeryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class StationeryRepositoryImpl implements StationeryRepository {

    private static StationeryRepositoryImpl repository = null;
    private Set<Stationery> stationerySet;

    private StationeryRepositoryImpl(){
        this.stationerySet = new HashSet<>();
    }

    public static StationeryRepositoryImpl getRepository(){
        if (repository == null) repository = new StationeryRepositoryImpl();
        return repository;
    }


    public Stationery create(Stationery stationery){
        this.stationerySet.add(stationery);
        return stationery;
    }

    private Stationery findStationery(String stationeryCode) {
        return this.stationerySet.stream()
                .filter(stationery -> stationery.getStationeryCode().trim().equals(stationeryCode))
                .findAny()
                .orElse(null);
    }

    public Stationery read(String stationeryCode){

        Stationery stationery = findStationery(stationeryCode);
        return stationery;
    }

    public void delete(String stationeryCode) {
        Stationery stationery = findStationery(stationeryCode);
        if (stationery != null) this.stationerySet.remove(stationery);

    }

    public Stationery update(Stationery stationery) {
        Stationery toDelete = findStationery(stationery.getStationeryCode());
        if (toDelete != null) {
            this.stationerySet.remove(toDelete);
            return create(stationery);
        }
        return null;
    }

    public Set<Stationery> getAll(){
        return this.stationerySet;
    }
}

