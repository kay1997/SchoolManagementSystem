package service.equipment.impl;

import domain.equipment.Projector;
import org.springframework.stereotype.Service;
import repository.equipment.ProjectorRepository;
import repository.equipment.impl.ProjectorRepositoryImpl;
import service.equipment.ProjectorService;

import java.util.Set;

@Service
public class ProjectorServiceImpl implements ProjectorService {

    private ProjectorServiceImpl service = null;
    private ProjectorRepository repository;

    private ProjectorServiceImpl() {
        this.repository = ProjectorRepositoryImpl.getRepository();
    }

    public ProjectorService getService() {
        if (service == null) service = new ProjectorServiceImpl();
        return service;
    }

    @Override
    public Projector create(Projector projector) {
        return this.repository.create(projector);
    }

    @Override
    public Projector update(Projector projector) {
        return this.repository.update(projector);
    }

    @Override
    public void delete(String projectorCode) {
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
