package com.repository.equipment.impl;

import com.domain.equipment.Chair;
import com.repository.equipment.ChairRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class ChairRepositoryImpl implements ChairRepository {

    private static ChairRepositoryImpl repository = null;
    private Set<Chair> chairs;

    private ChairRepositoryImpl(){
        this.chairs = new HashSet<>();
    }

    private Chair findChair(String chairNumber) {
        return this.chairs.stream()
                .filter(chair -> chair.getChairNumber().trim().equals(chairNumber))
                .findAny()
                .orElse(null);
    }


    public static ChairRepositoryImpl getRepository(){
        if (repository == null) repository = new ChairRepositoryImpl();
        return repository;
    }


    public Chair create(Chair chair){
        this.chairs.add(chair);
        return chair;
    }

    public Chair read(String chairNumber){

        Chair chair = findChair(chairNumber);
        return chair;
    }

    public void delete(String chairNumber) {
        Chair chair = findChair(chairNumber);
        if (chair != null) this.chairs.remove(chair);

    }

    public Chair update(Chair chair) {
        Chair toDelete = findChair(chair.getChairNumber());
        if (toDelete != null) {
            this.chairs.remove(toDelete);
            return create(chair);
        }
        return null;
    }

    public Set<Chair> getAll(){
        return this.chairs;
    }
}

