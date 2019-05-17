package repository.assessments;

import domain.assessments.Assignment;
import repository.IRepository;

import java.util.Set;

public interface AssignmentRepository extends IRepository<Assignment, String> {

    Set<Assignment> getAll();
}

