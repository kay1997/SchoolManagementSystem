package com.service.people;

import com.domain.people.Secretary;
import com.service.IService;

import java.util.Set;

public interface SecretaryService  extends IService<Secretary, String> {

    Set<Secretary> getAll();

}

