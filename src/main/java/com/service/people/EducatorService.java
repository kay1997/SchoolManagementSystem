package com.service.people;

import com.domain.people.Educator;
import com.service.IService;

import java.util.Set;

public interface EducatorService extends IService<Educator, String> {

    Set<Educator> getAll();
}
