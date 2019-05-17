package repository.admin;

import domain.admin.Result;
import repository.IRepository;

import java.util.Set;

public interface ResultRepository extends IRepository<Result, String> {

    Set<Result> getAll();

}