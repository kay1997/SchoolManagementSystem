package repository.equipment;

import domain.equipment.Computer;
import repository.IRepository;

import java.util.Set;

public interface ComputerRepository  extends IRepository<Computer, String> {

    Set<Computer> getAll();
}

