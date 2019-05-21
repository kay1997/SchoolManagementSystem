package com.service.infrastructure;

import com.domain.infrastructure.Lab;
import com.service.IService;

import java.util.Set;

public interface LabService  extends IService<Lab, String> {

    Set<Lab> getAll();

}
