package com.repository.people.impl;

import com.domain.people.Principle;
import com.repository.people.PrincipleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("RepositoryImpl")
public class PrincipleRepositoryImpl implements PrincipleRepository {
    @Autowired
    @Qualifier
    private static PrincipleRepositoryImpl repository = null;
    private Map<String, Principle> principles;

    private PrincipleRepositoryImpl() {
        this.principles = new HashMap<>();
    }

    public static PrincipleRepository getRepository(){
        if(repository == null) repository = new PrincipleRepositoryImpl();
        return repository;
    }

    public Principle create(Principle principle){
        this.principles.put(principle.getPrincipleIDNumber(),principle);
        return principle;
    }

    public Principle read(String principleId){
        return this.principles.get(principleId);
    }

    public Principle update(Principle principle) {
        this.principles.replace(principle.getPrincipleIDNumber(),principle);
        return this.principles.get(principle.getPrincipleIDNumber());
    }

    public void delete(String principleId) {
        this.principles.remove(principleId);
    }

    public Set<Principle> getAll(){
        Collection<Principle> principles = this.principles.values();
        Set<Principle> set = new HashSet<>();
        set.addAll(principles);
        return set;
    }
}