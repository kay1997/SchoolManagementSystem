package service.assessments;

import domain.assessments.Assignment;
import service.IService;

import java.util.Set;

public interface AssignmentService extends IService<Assignment, String> {

    Set<Assignment> getAll();

}