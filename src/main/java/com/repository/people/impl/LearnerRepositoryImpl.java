package com.repository.people.impl;

import com.domain.people.Learner;
import com.repository.people.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("RepositoryImpl")
public class LearnerRepositoryImpl implements LearnerRepository {
    private static LearnerRepositoryImpl repository = null;
    private Map<String, Learner> learners;

    private LearnerRepositoryImpl() {
        this.learners = new HashMap<>();
    }

    public static LearnerRepositoryImpl getRepository() {
        if (repository == null) repository = new LearnerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Learner> getAll() {
        Collection<Learner> learners = this.learners.values();
        Set<Learner> set = new HashSet<>();
        set.addAll(learners);
        return set;
    }

    @Override
    public Learner create(Learner learner) {
        if (read(learner.getLearnerId()) == null) {
            this.learners.put(learner.getLearnerId(), learner);
        }
        return learner;
    }

    @Override
    public Learner read(String e) {
        return this.learners.get(e);
    }

    @Override
    public Learner update(Learner learner) {
        if (read(learner.getLearnerId()) != null) {
            learners.replace(learner.getLearnerId(), learner);
        }
        return learner;
    }

    @Override
    public void delete(String e) {
        Learner learner = read(e);
        this.learners.remove(e, learner);
    }

}