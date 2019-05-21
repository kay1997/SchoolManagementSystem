package com.service.people;

import com.domain.people.Principle;
import com.service.IService;

import java.util.Set;

public interface PrincipleService  extends IService<Principle, String> {

    Set<Principle> getAll();

}
