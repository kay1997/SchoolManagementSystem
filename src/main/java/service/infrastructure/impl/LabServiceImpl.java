package service.infrastructure.impl;

import domain.infrastructure.Lab;
import org.springframework.stereotype.Service;
import repository.infrastructure.LabRepository;
import repository.infrastructure.impl.LabRepositoryImpl;
import service.infrastructure.LabService;

import java.util.Set;

@Service
public class LabServiceImpl implements LabService {

    private LabServiceImpl service = null;
    private LabRepository repository;

    private LabServiceImpl() {
        this.repository = LabRepositoryImpl.getRepository();
    }

    public LabService getService() {
        if (service == null) service = new LabServiceImpl();
        return service;
    }

    @Override
    public Lab create(Lab lab) {
        return this.repository.create(lab);
    }

    @Override
    public Lab update(Lab lab) {
        return this.repository.update(lab);
    }

    @Override
    public void delete(String labNumber) {
        this.repository.delete(labNumber);
    }

    @Override
    public Lab read(String labNumber) {
        return this.repository.read(labNumber);
    }

    @Override
    public Set<Lab> getAll() {
        return this.repository.getAll();
    }

}
