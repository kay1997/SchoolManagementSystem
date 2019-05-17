package service.infrastructure;

import domain.infrastructure.Lab;
import service.IService;

import java.util.Set;

public interface LabService  extends IService<Lab, String> {

    Set<Lab> getAll();

}
