package com.repository.infrastructure;


import com.domain.infrastructure.Lab;
import com.repository.IRepository;

import java.util.Set;

public interface LabRepository extends IRepository<Lab, String> {

    Set<Lab> getAll();

}