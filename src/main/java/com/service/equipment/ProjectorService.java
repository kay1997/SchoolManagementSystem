package com.service.equipment;

import com.domain.equipment.Projector;
import com.service.IService;

import java.util.Set;

public interface ProjectorService extends IService<Projector, String> {

    Set<Projector> getAll();

}