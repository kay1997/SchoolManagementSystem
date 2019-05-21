package com.repository.admin;

import com.domain.admin.Subject;
import com.repository.IRepository;

import java.util.Set;

public interface SubjectRepository extends IRepository<Subject, String> {

    Set<Subject> getAll();

}
