package com.service.admin.impl;

import com.domain.admin.School;
import com.service.admin.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.admin.SchoolRepository;
import com.repository.admin.impl.SchoolRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class SchoolServiceImpl implements SchoolService {
    private static SchoolServiceImpl service;
    private SchoolRepository repository;

    private SchoolServiceImpl(){this.repository = SchoolRepositoryImpl.getRepository();}

    public static SchoolServiceImpl getService()
    {
        if(service == null){service = new SchoolServiceImpl();}
        return service;
    }

    @Override
    public School create(School school){
        return this.repository.create(school);
    }

    @Override
    public School update(School school) {
        return this.repository.update(school);
    }

    @Override
    public void delete(String schoolCode){
        this.repository.delete(schoolCode);
    }

    @Override
    public School read(String schoolCode) {
        return this.repository.read(schoolCode);
    }

    @Override
    public Set<School> getAll() {
        return this.repository.getAll();
    }

}

