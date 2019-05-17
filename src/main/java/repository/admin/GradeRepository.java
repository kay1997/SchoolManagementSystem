package repository.admin;

import domain.admin.Grade;
import repository.IRepository;

import java.util.Set;

public interface GradeRepository  extends IRepository<Grade, String> {

        Set<Grade> getAll();
}
