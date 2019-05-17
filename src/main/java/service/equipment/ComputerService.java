package service.equipment;

import domain.equipment.Computer;
import service.IService;

import java.util.Set;

public interface ComputerService  extends IService<Computer, String> {

    Set<Computer> getAll();

}