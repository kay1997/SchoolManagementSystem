package service.infrastructure;

import domain.infrastructure.Building;
import service.IService;

import java.util.Set;

public interface BuildingService  extends IService<Building, String> {

    Set<Building> getAll();

}
