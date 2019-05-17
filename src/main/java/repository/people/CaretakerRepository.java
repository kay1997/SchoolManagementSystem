package repository.people;

import domain.people.Caretaker;
import repository.IRepository;

import java.util.Set;

public interface CaretakerRepository extends IRepository<Caretaker, String> {

    Set<Caretaker> getAll();
}
