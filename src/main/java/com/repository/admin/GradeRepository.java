package com.repository.admin;

import com.domain.admin.Grade;
import com.repository.IRepository;

import java.util.Set;

public interface GradeRepository  extends IRepository<Grade, String> {

        Set<Grade> getAll();
}
