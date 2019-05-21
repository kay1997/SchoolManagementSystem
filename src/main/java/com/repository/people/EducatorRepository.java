package com.repository.people;

import com.domain.people.Educator;
import com.repository.IRepository;

import java.util.Set;

public interface EducatorRepository  extends IRepository<Educator, String> {

    Set<Educator> getAll();
}
