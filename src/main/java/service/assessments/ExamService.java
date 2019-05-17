package service.assessments;

import domain.assessments.Exam;
import service.IService;

import java.util.Set;

public interface ExamService  extends IService<Exam, String> {

    Set<Exam> getAll();

}
