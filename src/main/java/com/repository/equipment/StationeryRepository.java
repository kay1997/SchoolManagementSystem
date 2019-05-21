package com.repository.equipment;

import com.domain.equipment.Stationery;
import com.repository.IRepository;

import java.util.Set;

public interface StationeryRepository extends IRepository<Stationery, String> {

    Set<Stationery> getAll();

}