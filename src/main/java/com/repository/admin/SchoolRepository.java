package com.repository.admin;

import com.domain.admin.School;
import com.repository.IRepository;

import java.util.Set;

public interface SchoolRepository extends IRepository<School, String> {

    Set<School> getAll();

}
