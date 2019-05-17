package service.equipment;

import domain.equipment.Desk;
import service.IService;

import java.util.Set;

public interface DeskService extends IService<Desk, String> {

    Set<Desk> getAll();

}
