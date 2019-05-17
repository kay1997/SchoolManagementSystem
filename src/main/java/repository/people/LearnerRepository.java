package repository.people;

import domain.people.Learner;
import repository.IRepository;

import java.util.Set;

public interface LearnerRepository extends IRepository<Learner, String> {

    Set<Learner> getAll();

}
