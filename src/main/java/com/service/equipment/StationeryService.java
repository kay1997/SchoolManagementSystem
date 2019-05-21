package com.service.equipment;

import com.domain.equipment.Stationery;
import com.service.IService;

import java.util.Set;

public interface StationeryService  extends IService<Stationery, String> {

    Set<Stationery> getAll();

}
