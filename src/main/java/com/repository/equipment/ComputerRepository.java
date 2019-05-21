package com.repository.equipment;

import com.domain.equipment.Computer;
import com.repository.IRepository;

import java.util.Set;

public interface ComputerRepository  extends IRepository<Computer, String> {

    Set<Computer> getAll();
}

