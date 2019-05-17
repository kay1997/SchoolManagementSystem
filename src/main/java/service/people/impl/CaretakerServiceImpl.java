package service.people.impl;


import domain.people.Caretaker;
import org.springframework.stereotype.Service;
import repository.people.CaretakerRepository;
import repository.people.impl.CaretakerRepositoryImpl;
import service.people.CaretakerService;

import java.util.Set;

@Service
public class CaretakerServiceImpl implements CaretakerService {

    private CaretakerServiceImpl service = null;
    private CaretakerRepository repository;

    private CaretakerServiceImpl(){
        this.repository = CaretakerRepositoryImpl.getRepository();
    }

    public CaretakerService getService(){
        if (service == null) service = new CaretakerServiceImpl();
        return service;
    }

    @Override
    public Caretaker create(Caretaker caretaker) {
        return this.repository.create(caretaker);
    }

    @Override
    public Caretaker update(Caretaker caretaker) {
        return this.repository.update(caretaker);
    }

    @Override
    public void delete(String caretakerIDNumber) {
        this.repository.delete(caretakerIDNumber);
    }

    @Override
    public Caretaker read(String caretakerIDNumber) {
        return this.repository.read(caretakerIDNumber);
    }

    @Override
    public Set<Caretaker> getAll() {
        return this.repository.getAll();
    }
}