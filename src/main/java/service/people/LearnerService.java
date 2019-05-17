package service.people;

import domain.people.Learner;
import service.IService;

import java.util.Set;

public interface LearnerService extends IService<Learner, String> {

    Set<Learner> getAll();


}
