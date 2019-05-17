package service.people.impl;

import domain.people.Security;
import org.springframework.stereotype.Service;
import repository.people.SecurityRepository;
import repository.people.impl.SecurityRepositoryImpl;
import service.people.SecurityService;

import java.util.Set;

@Service
public class SecurityServiceImpl  implements SecurityService{

    private SecurityServiceImpl service = null;
    private SecurityRepository repository;

    private SecurityServiceImpl(){
        this.repository = SecurityRepositoryImpl.getRepository();
    }

    public SecurityService getService(){
        if (service == null) service = new SecurityServiceImpl();
        return service;
    }

    @Override
    public Security create(Security security) {
        return this.repository.create(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.update(security);
    }

    @Override
    public void delete(String securityIDNumber) {
        this.repository.delete(securityIDNumber);
    }

    @Override
    public Security read(String securityIDNumber) {
        return this.repository.read(securityIDNumber);
    }

    @Override
    public Set<Security> getAll() {
        return this.repository.getAll();
    }
}
