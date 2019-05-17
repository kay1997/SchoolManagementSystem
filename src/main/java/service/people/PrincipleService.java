package service.people;

import domain.people.Principle;
import service.IService;

import java.util.Set;

public interface PrincipleService  extends IService<Principle, String> {

    Set<Principle> getAll();

}
