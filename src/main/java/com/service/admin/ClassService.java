package com.service.admin;

import com.domain.admin.Class;
import com.service.IService;

import java.util.Set;

public interface ClassService  extends IService<Class, String> {

    Set<Class> getAll();

}