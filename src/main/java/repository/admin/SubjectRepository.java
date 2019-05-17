package repository.admin;

import domain.admin.Subject;
import repository.IRepository;

import java.util.Set;

public interface SubjectRepository extends IRepository<Subject, String> {

    Set<Subject> getAll();

}
