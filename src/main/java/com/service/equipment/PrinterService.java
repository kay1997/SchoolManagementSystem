package com.service.equipment;

import com.domain.equipment.Printer;
import com.service.IService;

import java.util.Set;

public interface PrinterService  extends IService<Printer, String> {

    Set<Printer> getAll();

}
