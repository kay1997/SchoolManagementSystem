package com.service.admin;

import com.domain.admin.Subject;
import com.service.IService;

import java.util.Set;

public interface SubjectService  extends IService<Subject, String> {

    Set<Subject> getAll();

}
