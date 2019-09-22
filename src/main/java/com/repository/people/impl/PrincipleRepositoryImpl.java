package com.repository.people.impl;

import com.domain.people.Principle;
import com.repository.people.PrincipleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("RepositoryImpl")
public class PrincipleRepositoryImpl implements PrincipleRepository {
    private static PrincipleRepositoryImpl repository = null;
    private Map<String, Principle> principles;

    private PrincipleRepositoryImpl() {
        this.principles = new HashMap<>();
    }

    public static PrincipleRepositoryImpl getRepository() {
        if (repository == null) repository = new PrincipleRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Principle> getAll() {
        Collection<Principle> principles = this.principles.values();
        Set<Principle> set = new HashSet<>();
        set.addAll(principles);
        return set;
    }

    @Override
    public Principle create(Principle principle) {
        if (read(principle.getPrincipleIDNumber()) == null) {
            this.principles.put(principle.getPrincipleIDNumber(), principle);
        }
        return principle;
    }

    @Override
    public Principle read(String e) {
        return this.principles.get(e);
    }

    @Override
    public Principle update(Principle principle) {
        if (read(principle.getPrincipleIDNumber()) != null) {
            principles.replace(principle.getPrincipleIDNumber(), principle);
        }
        return principle;
    }

    @Override
    public void delete(String e) {
        Principle principle = read(e);
        this.principles.remove(e, principle);
    }

}