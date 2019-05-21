package com.repository.people.impl;

import com.domain.people.Secretary;
import com.repository.people.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class SecretaryRepositoryImpl implements SecretaryRepository
{
    @Autowired
    @Qualifier
    private static SecretaryRepositoryImpl repository = null;
    private Map<String, Secretary> secretarys;

    private SecretaryRepositoryImpl() {
        this.secretarys = new HashMap<>();
    }

    public static SecretaryRepository getRepository(){
        if(repository == null) repository = new SecretaryRepositoryImpl();
        return repository;
    }

    public Secretary create(Secretary secretary){
        this.secretarys.put(secretary.getSecretaryIDNumber(),secretary);
        return secretary;
    }

    public Secretary read(String secretaryId){
        return this.secretarys.get(secretaryId);
    }

    public Secretary update(Secretary secretary) {
        this.secretarys.replace(secretary.getSecretaryIDNumber(),secretary);
        return this.secretarys.get(secretary.getSecretaryIDNumber());
    }

    public void delete(String secretaryId) {
        this.secretarys.remove(secretaryId);
    }

    public Set<Secretary> getAll(){
        Collection<Secretary> secretarys = this.secretarys.values();
        Set<Secretary> set = new HashSet<>();
        set.addAll(secretarys);
        return set;
    }
}