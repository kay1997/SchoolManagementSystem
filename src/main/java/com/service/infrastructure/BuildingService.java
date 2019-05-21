package com.service.infrastructure;

import com.domain.infrastructure.Building;
import com.service.IService;

import java.util.Set;

public interface BuildingService  extends IService<Building, String> {

    Set<Building> getAll();

}
