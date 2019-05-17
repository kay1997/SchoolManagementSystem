package service.admin;

import domain.admin.Result;
import service.IService;

import java.util.Set;

public interface ResultService  extends IService<Result, String> {

    Set<Result> getAll();

}
