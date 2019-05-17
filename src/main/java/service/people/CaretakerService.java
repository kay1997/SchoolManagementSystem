package service.people;

import domain.people.Caretaker;
import service.IService;

import java.util.Set;

public interface CaretakerService  extends IService<Caretaker, String> {

    Set<Caretaker> getAll();

}
