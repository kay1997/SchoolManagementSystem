package com.repository.equipment;

import com.domain.equipment.Projector;
import com.repository.IRepository;

import java.util.Set;

public interface ProjectorRepository extends IRepository<Projector, String> {

    Set<Projector> getAll();

}