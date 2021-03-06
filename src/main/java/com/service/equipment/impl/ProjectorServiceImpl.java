package com.service.equipment.impl;

import com.domain.equipment.Projector;
import com.service.equipment.ProjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.ProjectorRepository;
import com.repository.equipment.impl.ProjectorRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class ProjectorServiceImpl implements ProjectorService {
    private static ProjectorServiceImpl service;
    private ProjectorRepository repository;

    private ProjectorServiceImpl(){this.repository = ProjectorRepositoryImpl.getRepository();}

    public static ProjectorServiceImpl getService()
    {
        if(service == null){service = new ProjectorServiceImpl();}
        return service;
    }

    @Override
    public Projector create(Projector projector){
        return this.repository.create(projector);
    }

    @Override
    public Projector update(Projector projector) {
        return this.repository.update(projector);
    }

    @Override
    public void delete(String projectorCode){
        this.repository.delete(projectorCode);
    }

    @Override
    public Projector read(String projectorCode) {
        return this.repository.read(projectorCode);
    }

    @Override
    public Set<Projector> getAll() {
        return this.repository.getAll();
    }

}
