package com.service.equipment;

import com.domain.equipment.Computer;
import com.service.IService;

import java.util.Set;

public interface ComputerService  extends IService<Computer, String> {

    Set<Computer> getAll();

}