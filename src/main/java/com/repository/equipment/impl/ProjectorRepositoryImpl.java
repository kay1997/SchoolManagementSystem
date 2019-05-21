package com.repository.equipment.impl;

import com.domain.equipment.Projector;
import com.repository.equipment.ProjectorRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class ProjectorRepositoryImpl implements ProjectorRepository {

    private static ProjectorRepositoryImpl repository = null;
    private Set<Projector> projectors;

    private ProjectorRepositoryImpl(){
        this.projectors = new HashSet<>();
    }

    public static ProjectorRepositoryImpl getRepository(){
        if (repository == null) repository = new ProjectorRepositoryImpl();
        return repository;
    }


    public Projector create(Projector projector){
        this.projectors.add(projector);
        return projector;
    }

    private Projector findProjector(String projectorCode) {
        return this.projectors.stream()
                .filter(projector -> projector.getProjectorCode().trim().equals(projectorCode))
                .findAny()
                .orElse(null);
    }

    public Projector read(String projectorCode){

        Projector projector = findProjector(projectorCode);
        return projector;
    }

    public void delete(String projectorCode) {
        Projector projector = findProjector(projectorCode);
        if (projector != null) this.projectors.remove(projector);

    }

    public Projector update(Projector projector) {
        Projector toDelete = findProjector(projector.getProjectorCode());
        if (toDelete != null) {
            this.projectors.remove(toDelete);
            return create(projector);
        }
        return null;
    }

    public Set<Projector> getAll(){
        return this.projectors;
    }
}
