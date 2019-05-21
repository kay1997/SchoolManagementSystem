package com.repository.people.impl;

import com.domain.people.Security;
import com.repository.people.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class SecurityRepositoryImpl implements SecurityRepository {
    @Autowired
    @Qualifier
    private static SecurityRepositoryImpl repository = null;
    private Map<String, Security> securitys;

    private SecurityRepositoryImpl() {
        this.securitys = new HashMap<>();
    }

    public static SecurityRepository getRepository(){
        if(repository == null) repository = new SecurityRepositoryImpl();
        return repository;
    }

    public Security create(Security security){
        this.securitys.put(security.getSecurityIDNumber(),security);
        return security;
    }

    public Security read(String securityId){
        return this.securitys.get(securityId);
    }

    public Security update(Security security) {
        this.securitys.replace(security.getSecurityIDNumber(),security);
        return this.securitys.get(security.getSecurityIDNumber());
    }

    public void delete(String securityId) {
        this.securitys.remove(securityId);
    }

    public Set<Security> getAll(){
        Collection<Security> securitys = this.securitys.values();
        Set<Security> set = new HashSet<>();
        set.addAll(securitys);
        return set;
    }
}