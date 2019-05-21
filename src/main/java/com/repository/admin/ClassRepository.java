package com.repository.admin;

import com.domain.admin.Class;
import com.repository.IRepository;

import java.util.Set;

public interface ClassRepository extends IRepository<Class, String> {

    Set<Class> getAll();
}

