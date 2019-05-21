package com.repository.people;

import com.domain.people.Principle;
import com.repository.IRepository;

import java.util.Set;

public interface PrincipleRepository extends IRepository<Principle, String> {

    Set<Principle> getAll();

}
