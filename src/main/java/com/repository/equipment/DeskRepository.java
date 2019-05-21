package com.repository.equipment;

import com.domain.equipment.Desk;
import com.repository.IRepository;

import java.util.Set;

public interface DeskRepository extends IRepository<Desk, String> {

    Set<Desk> getAll();
}
