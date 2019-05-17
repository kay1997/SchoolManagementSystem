package repository.people;

import domain.people.Principle;
import repository.IRepository;

import java.util.Set;

public interface PrincipleRepository extends IRepository<Principle, String> {

    Set<Principle> getAll();

}
