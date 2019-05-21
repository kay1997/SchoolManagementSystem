package com.repository.people;

import com.domain.people.Caretaker;
import com.repository.IRepository;

import java.util.Set;

public interface CaretakerRepository extends IRepository<Caretaker, String> {

    Set<Caretaker> getAll();
}
