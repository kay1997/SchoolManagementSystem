package service.people.impl;

import domain.people.Educator;
import org.springframework.stereotype.Service;
import repository.people.EducatorRepository;
import repository.people.impl.EducatorRepositoryImpl;
import service.people.EducatorService;

import java.util.Set;

@Service
public class EducatorServiceImpl implements EducatorService{

    private EducatorServiceImpl service = null;
    private EducatorRepository repository;

    private EducatorServiceImpl(){
        this.repository = EducatorRepositoryImpl.getRepository();
    }

    public EducatorService getService(){
        if (service == null) service = new EducatorServiceImpl();
        return service;
    }

    @Override
    public Educator create(Educator educator) {
        return this.repository.create(educator);
    }

    @Override
    public Educator update(Educator educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String educatorIDNumber) {
        this.repository.delete(educatorIDNumber);
    }

    @Override
    public Educator read(String educatorIDNumber) {
        return this.repository.read(educatorIDNumber);
    }

    @Override
    public Set<Educator> getAll() {
        return this.repository.getAll();
    }
}

