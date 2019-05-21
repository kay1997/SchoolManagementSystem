package com.service.admin;

import com.domain.admin.School;
import com.service.IService;

import java.util.Set;

public interface SchoolService  extends IService<School, String> {

    Set<School> getAll();

}
