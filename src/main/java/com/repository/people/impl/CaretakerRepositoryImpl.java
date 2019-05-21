package com.repository.people.impl;

import com.domain.people.Caretaker;
import com.repository.people.CaretakerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CaretakerRepositoryImpl implements CaretakerRepository {

    private static CaretakerRepositoryImpl repository = null;
    private Set<Caretaker> caretakers;

    private CaretakerRepositoryImpl(){
        this.caretakers = new HashSet<>();
    }

    public static CaretakerRepositoryImpl getRepository(){
        if (repository == null) repository = new CaretakerRepositoryImpl();
        return repository;
    }


    public Caretaker create(Caretaker caretaker){
        this.caretakers.add(caretaker);
        return caretaker;
    }

    private Caretaker findCaretaker(String caretakerIDNumber) {
        return this.caretakers.stream()
                .filter(caretaker -> caretaker.getCaretakerIDNumber().trim().equals(caretakerIDNumber))
                .findAny()
                .orElse(null);
    }

    public Caretaker read(String caretakerIDNumber){

        Caretaker caretaker = findCaretaker(caretakerIDNumber);
        return caretaker;
    }

    public void delete(String caretakerIDNumber) {
        Caretaker caretaker = findCaretaker(caretakerIDNumber);
        if (caretaker != null) this.caretakers.remove(caretaker);

    }

    public Caretaker update(Caretaker caretaker) {
        Caretaker toDelete = findCaretaker(caretaker.getCaretakerIDNumber());
        if (toDelete != null) {
            this.caretakers.remove(toDelete);
            return create(caretaker);
        }
        return null;
    }


    public Set<Caretaker> getAll(){
        return this.caretakers;
    }
}
