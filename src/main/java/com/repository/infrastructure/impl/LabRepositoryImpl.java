package com.repository.infrastructure.impl;

import com.domain.infrastructure.Lab;
import org.springframework.stereotype.Repository;
import com.repository.infrastructure.LabRepository;

import java.util.*;

@Repository("InMemory")
public class LabRepositoryImpl implements LabRepository {
    private static LabRepositoryImpl repository = null;
    private Map<String, Lab> labs;

    private LabRepositoryImpl() {
        this.labs = new HashMap<>();
    }

    public static LabRepositoryImpl getRepository() {
        if (repository == null) repository = new LabRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Lab> getAll() {
        Collection<Lab> labs = this.labs.values();
        Set<Lab> set = new HashSet<>();
        set.addAll(labs);
        return set;
    }

    @Override
    public Lab create(Lab lab) {
        if (read(lab.getLabNumber()) == null) {
            this.labs.put(lab.getLabNumber(), lab);
        }
        return lab;
    }

    @Override
    public Lab read(String e) {
        return this.labs.get(e);
    }

    @Override
    public Lab update(Lab lab) {
        if (read(lab.getLabNumber()) != null) {
            labs.replace(lab.getLabNumber(), lab);
        }
        return lab;
    }

    @Override
    public void delete(String e) {
        Lab lab = read(e);
        this.labs.remove(e, lab);
    }

}