package repository.infrastructure;

import domain.infrastructure.Building;
import repository.IRepository;

import java.util.Set;

public interface BuildingRepository extends IRepository<Building, String> {

    Set<Building> getAll();
}

