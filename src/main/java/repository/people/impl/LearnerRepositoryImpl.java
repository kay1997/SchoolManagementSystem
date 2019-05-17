package repository.people.impl;

import domain.people.Learner;
import repository.people.LearnerRepository;

import java.util.HashSet;
import java.util.Set;

public class LearnerRepositoryImpl implements LearnerRepository {

    private static LearnerRepositoryImpl repository = null;
    private Set<Learner> learners;

    private LearnerRepositoryImpl(){
        this.learners = new HashSet<>();
    }

    public static LearnerRepositoryImpl getRepository(){
        if (repository == null) repository = new LearnerRepositoryImpl();
        return repository;
    }


    public Learner create(Learner learner){
        this.learners.add(learner);
        return learner;
    }

    private Learner findLearner(String learnerID) {
        return this.learners.stream()
                .filter(learner -> learner.getLearnerId().trim().equals(learnerID))
                .findAny()
                .orElse(null);
    }

    public Learner read(String learnerID){

        Learner learner = findLearner(learnerID);
        return learner;
    }

    public void delete(String learnerID) {
        Learner learner = findLearner(learnerID);
        if (learner != null) this.learners.remove(learner);

    }

    public Learner update(Learner learner) {
        Learner toDelete = findLearner(learner.getLearnerId());
        if (toDelete != null) {
            this.learners.remove(toDelete);
            return create(learner);
        }
        return null;
    }



    public Set<Learner> getAll(){
        return this.learners;
    }
}
