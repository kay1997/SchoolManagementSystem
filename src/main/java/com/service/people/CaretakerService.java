package com.service.people;

import com.domain.people.Caretaker;
import com.service.IService;

import java.util.Set;

public interface CaretakerService  extends IService<Caretaker, String> {

    Set<Caretaker> getAll();

}
