package com.repository.people;

import com.domain.people.Security;
import com.repository.IRepository;

import java.util.Set;

public interface SecurityRepository extends IRepository<Security, String> {

    Set<Security> getAll();

}
