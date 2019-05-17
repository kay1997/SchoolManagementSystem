package service.equipment;

import domain.equipment.Projector;
import service.IService;

import java.util.Set;

public interface ProjectorService extends IService<Projector, String> {

    Set<Projector> getAll();

}