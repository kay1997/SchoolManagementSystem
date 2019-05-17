package service.people.impl;

import domain.people.Principle;
import org.springframework.stereotype.Service;
import repository.people.PrincipleRepository;
import repository.people.impl.PrincipleRepositoryImpl;
import service.people.PrincipleService;

import java.util.Set;

@Service
public class PrincipleServiceImpl implements PrincipleService{

    private PrincipleServiceImpl service = null;
    private PrincipleRepository repository;

    private PrincipleServiceImpl(){
        this.repository = PrincipleRepositoryImpl.getRepository();
    }

    public PrincipleService getService(){
        if (service == null) service = new PrincipleServiceImpl();
        return service;
    }

    @Override
    public Principle create(Principle principle) {
        return this.repository.create(principle);
    }

    @Override
    public Principle update(Principle principle) {
        return this.repository.update(principle);
    }

    @Override
    public void delete(String principleIDNumber) {
        this.repository.delete(principleIDNumber);
    }

    @Override
    public Principle read(String principleIDNumber) {
        return this.repository.read(principleIDNumber);
    }

    @Override
    public Set<Principle> getAll() {
        return this.repository.getAll();
    }
}

