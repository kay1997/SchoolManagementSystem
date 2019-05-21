package com.service.people;

import com.domain.people.Security;
import com.service.IService;

import java.util.Set;

public interface SecurityService   extends IService<Security, String> {

    Set<Security> getAll();

}