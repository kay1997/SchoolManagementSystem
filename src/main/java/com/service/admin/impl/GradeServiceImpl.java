package com.service.admin.impl;

import com.domain.admin.Grade;
import com.service.admin.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.admin.GradeRepository;
import com.repository.admin.impl.GradeRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class GradeServiceImpl implements GradeService {
    private static GradeServiceImpl service;
    private GradeRepository repository;

    private GradeServiceImpl(){this.repository = GradeRepositoryImpl.getRepository();}

    public static GradeServiceImpl getService()
    {
        if(service == null){service = new GradeServiceImpl();}
        return service;
    }

    @Override
    public Grade create(Grade grade){
        return this.repository.create(grade);
    }

    @Override
    public Grade update(Grade grade) {
        return this.repository.update(grade);
    }

    @Override
    public void delete(String gradeNumber){
        this.repository.delete(gradeNumber);
    }

    @Override
    public Grade read(String gradeNumber) {
        return this.repository.read(gradeNumber);
    }

    @Override
    public Set<Grade> getAll() {
        return this.repository.getAll();
    }

}

