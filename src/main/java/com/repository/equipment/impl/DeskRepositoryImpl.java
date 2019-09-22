package com.repository.equipment.impl;

import com.domain.equipment.Desk;
import com.repository.equipment.DeskRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class DeskRepositoryImpl implements DeskRepository {

    private static DeskRepositoryImpl repository = null;
    private Map<String, Desk> desks;

    private DeskRepositoryImpl() {
        this.desks = new HashMap<>();
    }

    public static DeskRepositoryImpl getRepository() {
        if (repository == null) repository = new DeskRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Desk> getAll() {
        Collection<Desk> desks = this.desks.values();
        Set<Desk> set = new HashSet<>();
        set.addAll(desks);
        return set;
    }

    @Override
    public Desk create(Desk desk) {
        if (read(desk.getDeskNumber()) == null) {
            this.desks.put(desk.getDeskNumber(), desk);
        }
        return desk;
    }

    @Override
    public Desk read(String e) {
        return this.desks.get(e);
    }

    @Override
    public Desk update(Desk desk) {
        if (read(desk.getDeskNumber()) != null) {
            desks.replace(desk.getDeskNumber(), desk);
        }
        return desk;
    }

    @Override
    public void delete(String e) {
        Desk desk = read(e);
        this.desks.remove(e, desk);
    }

}