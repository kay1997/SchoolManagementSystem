package com.repository.people.impl;

import com.domain.people.Learner;
import com.repository.people.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("RepositoryImpl")
public class LearnerRepositoryImpl implements LearnerRepository {
    @Autowired
    @Qualifier
    private static LearnerRepositoryImpl repository = null;
    private Map<String, Learner> learners;

    private LearnerRepositoryImpl() {
        this.learners = new HashMap<>();
    }

    public static LearnerRepository getRepository(){
        if(repository == null) repository = new LearnerRepositoryImpl();
        return repository;
    }

    public Learner create(Learner learner){
        this.learners.put(learner.getLearnerId(),learner);
        return learner;
    }

    public Learner read(String learnerId){
        return this.learners.get(learnerId);
    }

    public Learner update(Learner learner) {
        this.learners.replace(learner.getLearnerId(),learner);
        return this.learners.get(learner.getLearnerId());
    }

    public void delete(String learnerId) {
        this.learners.remove(learnerId);
    }

    public Set<Learner> getAll(){
        Collection<Learner> learners = this.learners.values();
        Set<Learner> set = new HashSet<>();
        set.addAll(learners);
        return set;
    }
}