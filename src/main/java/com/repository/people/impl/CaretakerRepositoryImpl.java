package com.repository.people.impl;

import com.domain.people.Caretaker;
import com.repository.people.CaretakerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CaretakerRepositoryImpl implements CaretakerRepository {
    private static CaretakerRepositoryImpl repository = null;
    private Map<String, Caretaker> caretakers;

    private CaretakerRepositoryImpl() {
        this.caretakers = new HashMap<>();
    }

    public static CaretakerRepositoryImpl getRepository() {
        if (repository == null) repository = new CaretakerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Caretaker> getAll() {
        Collection<Caretaker> caretakers = this.caretakers.values();
        Set<Caretaker> set = new HashSet<>();
        set.addAll(caretakers);
        return set;
    }

    @Override
    public Caretaker create(Caretaker caretaker) {
        if (read(caretaker.getCaretakerIDNumber()) == null) {
            this.caretakers.put(caretaker.getCaretakerIDNumber(), caretaker);
        }
        return caretaker;
    }

    @Override
    public Caretaker read(String e) {
        return this.caretakers.get(e);
    }

    @Override
    public Caretaker update(Caretaker caretaker) {
        if (read(caretaker.getCaretakerIDNumber()) != null) {
            caretakers.replace(caretaker.getCaretakerIDNumber(), caretaker);
        }
        return caretaker;
    }

    @Override
    public void delete(String e) {
        Caretaker caretaker = read(e);
        this.caretakers.remove(e, caretaker);
    }

}