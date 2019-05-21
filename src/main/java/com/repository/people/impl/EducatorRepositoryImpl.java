package com.repository.people.impl;

import com.domain.people.Educator;
import com.repository.people.EducatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("educatorRepository")
public class EducatorRepositoryImpl implements EducatorRepository {
    @Autowired
    @Qualifier
    private static EducatorRepositoryImpl repository = null;
    private Map<String, Educator> educators;

    private EducatorRepositoryImpl() {
        this.educators = new HashMap<>();
    }

    public static EducatorRepository getRepository(){
        if(repository == null) repository = new EducatorRepositoryImpl();
        return repository;
    }

    public Educator create(Educator educator){
        this.educators.put(educator.getEducatorIDNumber(),educator);
        return educator;
    }

    public Educator read(String educatorId){
        return this.educators.get(educatorId);
    }

    public Educator update(Educator educator) {
        this.educators.replace(educator.getEducatorIDNumber(),educator);
        return this.educators.get(educator.getEducatorIDNumber());
    }

    public void delete(String educatorId) {
        this.educators.remove(educatorId);
    }

    public Set<Educator> getAll(){
        Collection<Educator> educators = this.educators.values();
        Set<Educator> set = new HashSet<>();
        set.addAll(educators);
        return set;
    }
}