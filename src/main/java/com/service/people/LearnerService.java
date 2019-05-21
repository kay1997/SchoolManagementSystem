package com.service.people;

import com.domain.people.Learner;
import com.service.IService;

import java.util.Set;

public interface LearnerService extends IService<Learner, String> {

    Set<Learner> getAll();


}
