package com.repository.equipment;

import com.domain.equipment.Printer;
import com.repository.IRepository;

import java.util.Set;

public interface PrinterRepository extends IRepository<Printer, String> {

    Set<Printer> getAll();

}
