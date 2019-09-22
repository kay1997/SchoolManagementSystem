package com.repository.people.impl;

import com.domain.people.Educator;
import com.repository.people.EducatorRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("repository")
public class EducatorRepositoryImpl implements EducatorRepository {
    private static EducatorRepositoryImpl repository = null;
    private Map<String, Educator> educators;

    private EducatorRepositoryImpl() {
        this.educators = new HashMap<>();
    }

    public static EducatorRepositoryImpl getRepository() {
        if (repository == null) repository = new EducatorRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Educator> getAll() {
        Collection<Educator> educators = this.educators.values();
        Set<Educator> set = new HashSet<>();
        set.addAll(educators);
        return set;
    }

    @Override
    public Educator create(Educator educator) {
        if (read(educator.getEducatorIDNumber()) == null) {
            this.educators.put(educator.getEducatorIDNumber(), educator);
        }
        return educator;
    }

    @Override
    public Educator read(String e) {
        return this.educators.get(e);
    }

    @Override
    public Educator update(Educator educator) {
        if (read(educator.getEducatorIDNumber()) != null) {
            educators.replace(educator.getEducatorIDNumber(), educator);
        }
        return educator;
    }

    @Override
    public void delete(String e) {
        Educator educator = read(e);
        this.educators.remove(e, educator);
    }

}