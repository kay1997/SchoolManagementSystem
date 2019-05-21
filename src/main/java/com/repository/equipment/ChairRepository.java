package com.repository.equipment;

import com.domain.equipment.Chair;
import com.repository.IRepository;

import java.util.Set;

public interface ChairRepository extends IRepository<Chair, String> {

    Set<Chair> getAll();
}

