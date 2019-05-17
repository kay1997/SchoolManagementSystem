package service.people.impl;

import domain.people.Learner;
import org.springframework.stereotype.Service;
import repository.people.LearnerRepository;
import repository.people.impl.LearnerRepositoryImpl;
import service.people.LearnerService;

import java.util.Set;

@Service
public class LearnerServiceImpl implements LearnerService{

    private LearnerServiceImpl service = null;
    private LearnerRepository repository;

    private LearnerServiceImpl(){
        this.repository = LearnerRepositoryImpl.getRepository();
    }

    public LearnerService getService(){
        if (service == null) service = new LearnerServiceImpl();
        return service;
    }

    @Override
    public Learner create(Learner learner) {
        return this.repository.create(learner);
    }

    @Override
    public Learner update(Learner learner) {
        return this.repository.update(learner);
    }

    @Override
    public void delete(String learnerId) {
        this.repository.delete(learnerId);
    }

    @Override
    public Learner read(String learnerId) {
        return this.repository.read(learnerId);
    }

    @Override
    public Set<Learner> getAll() {
        return this.repository.getAll();
    }
}
