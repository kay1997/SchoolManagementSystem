package com.repository.people;

import com.domain.people.Learner;
import com.repository.IRepository;

import java.util.Set;

public interface LearnerRepository extends IRepository<Learner, String> {

    Set<Learner> getAll();

}
