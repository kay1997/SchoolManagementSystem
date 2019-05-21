package com.repository.admin;

import com.domain.admin.Result;
import com.repository.IRepository;

import java.util.Set;

public interface ResultRepository extends IRepository<Result, String> {

    Set<Result> getAll();

}