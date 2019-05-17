package repository.people;

import domain.people.Security;
import repository.IRepository;

import java.util.Set;

public interface SecurityRepository extends IRepository<Security, String> {

    Set<Security> getAll();

}
