package com.service.admin;

import com.domain.admin.Result;
import com.service.IService;

import java.util.Set;

public interface ResultService  extends IService<Result, String> {

    Set<Result> getAll();

}
