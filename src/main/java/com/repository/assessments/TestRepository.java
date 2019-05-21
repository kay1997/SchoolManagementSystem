package com.repository.assessments;

import com.domain.assessments.Test;
import com.repository.IRepository;

import java.util.Set;

public interface TestRepository extends IRepository<Test, String> {

    Set<Test> getAll();

}
