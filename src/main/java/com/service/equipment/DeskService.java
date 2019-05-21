package com.service.equipment;

import com.domain.equipment.Desk;
import com.service.IService;

import java.util.Set;

public interface DeskService extends IService<Desk, String> {

    Set<Desk> getAll();

}
