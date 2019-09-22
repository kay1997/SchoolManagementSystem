package com.repository.people.impl;

import com.domain.people.Security;
import com.repository.people.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class SecurityRepositoryImpl implements SecurityRepository {
    private static SecurityRepositoryImpl repository = null;
    private Map<String, Security> securities;

    private SecurityRepositoryImpl() {
        this.securities = new HashMap<>();
    }

    public static SecurityRepositoryImpl getRepository() {
        if (repository == null) repository = new SecurityRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Security> getAll() {
        Collection<Security> securities = this.securities.values();
        Set<Security> set = new HashSet<>();
        set.addAll(securities);
        return set;
    }

    @Override
    public Security create(Security security) {
        if (read(security.getSecurityIDNumber()) == null) {
            this.securities.put(security.getSecurityIDNumber(), security);
        }
        return security;
    }

    @Override
    public Security read(String e) {
        return this.securities.get(e);
    }

    @Override
    public Security update(Security security) {
        if (read(security.getSecurityIDNumber()) != null) {
            securities.replace(security.getSecurityIDNumber(), security);
        }
        return security;
    }

    @Override
    public void delete(String e) {
        Security security = read(e);
        this.securities.remove(e, security);
    }

}