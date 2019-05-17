package repository.admin;

import domain.admin.School;
import repository.IRepository;

import java.util.Set;

public interface SchoolRepository extends IRepository<School, String> {

    Set<School> getAll();

}
