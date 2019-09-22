package com.service.people.impl;

import com.domain.people.Security;
import com.service.people.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.people.SecurityRepository;
import com.repository.people.impl.SecurityRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class SecurityServiceImpl  implements SecurityService {
    private static SecurityServiceImpl service;
    private SecurityRepository repository;

    private SecurityServiceImpl(){this.repository = SecurityRepositoryImpl.getRepository();}

    public static SecurityServiceImpl getService()
    {
        if(service == null){service = new SecurityServiceImpl();}
        return service;
    }

    @Override
    public Security create(Security security){
        return this.repository.create(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.update(security);
    }

    @Override
    public void delete(String securityIDNumber){
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
