package service.people.impl;



import domain.people.Secretary;
import org.springframework.stereotype.Service;
import repository.people.SecretaryRepository;
import repository.people.impl.SecretaryRepositoryImpl;
import service.people.SecretaryService;

import java.util.Set;

@Service
public class SecretaryServiceImpl implements SecretaryService {

    private SecretaryServiceImpl service = null;
    private SecretaryRepository repository;

    private SecretaryServiceImpl(){
        this.repository = SecretaryRepositoryImpl.getRepository();
    }

    public SecretaryService getService(){
        if (service == null) service = new SecretaryServiceImpl();
        return service;
    }

    @Override
    public Secretary create(Secretary secretary) {
        return this.repository.create(secretary);
    }

    @Override
    public Secretary update(Secretary secretary) {
        return this.repository.update(secretary);
    }

    @Override
    public void delete(String secretaryIDNumber) {
        this.repository.delete(secretaryIDNumber);
    }

    @Override
    public Secretary read(String secretaryIDNumber) {
        return this.repository.read(secretaryIDNumber);
    }

    @Override
    public Set<Secretary> getAll() {
        return this.repository.getAll();
    }
}
