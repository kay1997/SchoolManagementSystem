package repository.equipment;

import domain.equipment.Projector;
import repository.IRepository;

import java.util.Set;

public interface ProjectorRepository extends IRepository<Projector, String> {

    Set<Projector> getAll();

}