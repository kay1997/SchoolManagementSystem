package service.admin;

import domain.admin.School;
import service.IService;

import java.util.Set;

public interface SchoolService  extends IService<School, String> {

    Set<School> getAll();

}
