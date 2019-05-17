package repository.equipment;

import domain.equipment.Chair;
import repository.IRepository;

import java.util.Set;

public interface ChairRepository extends IRepository<Chair, String> {

    Set<Chair> getAll();
}

