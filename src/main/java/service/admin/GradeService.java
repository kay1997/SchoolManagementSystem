package service.admin;

import domain.admin.Grade;
import service.IService;

import java.util.Set;

public interface GradeService  extends IService<Grade, String> {

    Set<Grade> getAll();

}
