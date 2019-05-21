package com.service.assessments;

import com.domain.assessments.Test;
import com.service.IService;

import java.util.Set;

public interface TestService extends IService<Test, String> {

    Set<Test> getAll();

}
