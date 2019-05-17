package service.equipment;

import domain.equipment.Printer;
import service.IService;

import java.util.Set;

public interface PrinterService  extends IService<Printer, String> {

    Set<Printer> getAll();

}
