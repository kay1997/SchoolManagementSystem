package service.people;

import domain.people.Educator;
import service.IService;

import java.util.Set;

public interface EducatorService extends IService<Educator, String> {

    Set<Educator> getAll();
}
