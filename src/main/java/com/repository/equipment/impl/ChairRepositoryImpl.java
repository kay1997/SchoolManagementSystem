package com.repository.equipment.impl;

import com.domain.equipment.Chair;
import com.repository.equipment.ChairRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class ChairRepositoryImpl implements ChairRepository {

    private static ChairRepositoryImpl repository = null;
    private Map<String, Chair> chairs;

    private ChairRepositoryImpl() {
        this.chairs = new HashMap<>();
    }

    public static ChairRepositoryImpl getRepository() {
        if (repository == null) repository = new ChairRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Chair> getAll() {
        Collection<Chair> chairs = this.chairs.values();
        Set<Chair> set = new HashSet<>();
        set.addAll(chairs);
        return set;
    }

    @Override
    public Chair create(Chair chair) {
        if (read(chair.getChairNumber()) == null) {
            this.chairs.put(chair.getChairNumber(), chair);
        }
        return chair;
    }

    @Override
    public Chair read(String e) {
        return this.chairs.get(e);
    }

    @Override
    public Chair update(Chair chair) {
        if (read(chair.getChairNumber()) != null) {
            chairs.replace(chair.getChairNumber(), chair);
        }
        return chair;
    }

    @Override
    public void delete(String e) {
        Chair chair = read(e);
        this.chairs.remove(e, chair);
    }

}