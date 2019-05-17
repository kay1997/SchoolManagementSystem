package service.admin;

import domain.admin.Subject;
import service.IService;

import java.util.Set;

public interface SubjectService  extends IService<Subject, String> {

    Set<Subject> getAll();

}
