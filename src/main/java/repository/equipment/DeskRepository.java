package repository.equipment;

import domain.equipment.Desk;
import repository.IRepository;

import java.util.Set;

public interface DeskRepository extends IRepository<Desk, String> {

    Set<Desk> getAll();
}
