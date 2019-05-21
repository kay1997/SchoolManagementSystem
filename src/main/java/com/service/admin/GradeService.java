package com.service.admin;

import com.domain.admin.Grade;
import com.service.IService;

import java.util.Set;

public interface GradeService  extends IService<Grade, String> {

    Set<Grade> getAll();

}
