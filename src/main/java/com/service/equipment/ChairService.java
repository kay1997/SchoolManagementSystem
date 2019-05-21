package com.service.equipment;

import com.domain.equipment.Chair;
import com.service.IService;

import java.util.Set;

public interface ChairService extends IService<Chair, String> {

    Set<Chair> getAll();

}
