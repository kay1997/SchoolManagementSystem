package repository.people;

import domain.people.Educator;
import repository.IRepository;

import java.util.Set;

public interface EducatorRepository  extends IRepository<Educator, String> {

    Set<Educator> getAll();
}
