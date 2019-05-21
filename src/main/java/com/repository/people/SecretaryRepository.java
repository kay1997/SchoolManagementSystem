package com.repository.people;

import com.domain.people.Secretary;
import com.repository.IRepository;

import java.util.Set;

public interface SecretaryRepository extends IRepository<Secretary, String> {

    Set<Secretary> getAll();

}