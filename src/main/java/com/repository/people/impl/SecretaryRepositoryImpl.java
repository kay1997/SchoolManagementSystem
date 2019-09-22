package com.repository.people.impl;

import com.domain.people.Secretary;
import com.repository.people.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class SecretaryRepositoryImpl implements SecretaryRepository
{ private static SecretaryRepositoryImpl repository = null;
    private Map<String, Secretary> secrataries;

    private SecretaryRepositoryImpl() {
        this.secrataries = new HashMap<>();
    }

    public static SecretaryRepositoryImpl getRepository() {
        if (repository == null) repository = new SecretaryRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Secretary> getAll() {
        Collection<Secretary> secrataries = this.secrataries.values();
        Set<Secretary> set = new HashSet<>();
        set.addAll(secrataries);
        return set;
    }

    @Override
    public Secretary create(Secretary secretary) {
        if (read(secretary.getSecretaryIDNumber()) == null) {
            this.secrataries.put(secretary.getSecretaryIDNumber(), secretary);
        }
        return secretary;
    }

    @Override
    public Secretary read(String e) {
        return this.secrataries.get(e);
    }

    @Override
    public Secretary update(Secretary secretary) {
        if (read(secretary.getSecretaryIDNumber()) != null) {
            secrataries.replace(secretary.getSecretaryIDNumber(), secretary);
        }
        return secretary;
    }

    @Override
    public void delete(String e) {
        Secretary secretary = read(e);
        this.secrataries.remove(e, secretary);
    }

}