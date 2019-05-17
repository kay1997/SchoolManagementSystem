package repository.infrastructure;


import domain.infrastructure.Lab;
import repository.IRepository;

import java.util.Set;

public interface LabRepository extends IRepository<Lab, String> {

    Set<Lab> getAll();

}