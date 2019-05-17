package repository.equipment;

import domain.equipment.Printer;
import repository.IRepository;

import java.util.Set;

public interface PrinterRepository extends IRepository<Printer, String> {

    Set<Printer> getAll();

}
