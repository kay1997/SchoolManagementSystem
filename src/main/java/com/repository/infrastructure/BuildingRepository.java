package com.repository.infrastructure;

import com.domain.infrastructure.Building;
import com.repository.IRepository;

import java.util.Set;

public interface BuildingRepository extends IRepository<Building, String> {

    Set<Building> getAll();
}

