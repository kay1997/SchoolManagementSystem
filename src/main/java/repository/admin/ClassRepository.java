package repository.admin;

import domain.admin.Class;
import repository.IRepository;

import java.util.Set;

public interface ClassRepository extends IRepository<Class, String> {

    Set<Class> getAll();
}

