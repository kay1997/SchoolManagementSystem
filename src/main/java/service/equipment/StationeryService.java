package service.equipment;

import domain.equipment.Stationery;
import service.IService;

import java.util.Set;

public interface StationeryService  extends IService<Stationery, String> {

    Set<Stationery> getAll();

}
