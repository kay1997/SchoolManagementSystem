package com.repository.equipment.impl;

import com.domain.equipment.Projector;
import com.repository.equipment.ProjectorRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class ProjectorRepositoryImpl implements ProjectorRepository {

    private static ProjectorRepositoryImpl repository = null;
    private Map<String, Projector> projectors;

    private ProjectorRepositoryImpl() {
        this.projectors = new HashMap<>();
    }

    public static ProjectorRepositoryImpl getRepository() {
        if (repository == null) repository = new ProjectorRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Projector> getAll() {
        Collection<Projector> projectors = this.projectors.values();
        Set<Projector> set = new HashSet<>();
        set.addAll(projectors);
        return set;
    }

    @Override
    public Projector create(Projector projector) {
        if (read(projector.getProjectorCode()) == null) {
            this.projectors.put(projector.getProjectorCode(), projector);
        }
        return projector;
    }

    @Override
    public Projector read(String e) {
        return this.projectors.get(e);
    }

    @Override
    public Projector update(Projector projector) {
        if (read(projector.getProjectorCode()) != null) {
            projectors.replace(projector.getProjectorCode(), projector);
        }
        return projector;
    }

    @Override
    public void delete(String e) {
        Projector projector = read(e);
        this.projectors.remove(e, projector);
    }

}