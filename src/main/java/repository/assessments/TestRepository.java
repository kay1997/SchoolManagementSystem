package repository.assessments;

import domain.assessments.Test;
import repository.IRepository;

import java.util.Set;

public interface TestRepository extends IRepository<Test, String> {

    Set<Test> getAll();

}
