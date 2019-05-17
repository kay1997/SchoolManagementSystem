package repository.assessments;

import domain.assessments.Exam;
import repository.IRepository;

import java.util.Set;

public interface ExamRepository extends IRepository<Exam, String> {

    Set<Exam> getAll();
}

