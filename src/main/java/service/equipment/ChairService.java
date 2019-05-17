package service.equipment;

import domain.equipment.Chair;
import service.IService;

import java.util.Set;

public interface ChairService extends IService<Chair, String> {

    Set<Chair> getAll();

}
