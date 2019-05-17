package service.admin;

import domain.admin.Class;
import service.IService;

import java.util.Set;

public interface ClassService  extends IService<Class, String> {

    Set<Class> getAll();

}