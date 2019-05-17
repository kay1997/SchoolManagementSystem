package repository.equipment;

import domain.equipment.Stationery;
import repository.IRepository;

import java.util.Set;

public interface StationeryRepository extends IRepository<Stationery, String> {

    Set<Stationery> getAll();

}