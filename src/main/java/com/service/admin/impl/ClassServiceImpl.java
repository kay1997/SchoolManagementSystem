package com.service.admin.impl;

import com.domain.admin.Class;
import com.service.admin.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.admin.ClassRepository;
import com.repository.admin.impl.ClassRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class ClassServiceImpl implements ClassService {

    private static ClassServiceImpl service;
    private ClassRepository repository;

    private ClassServiceImpl(){this.repository = ClassRepositoryImpl.getRepository();}

    public static ClassServiceImpl getService()
    {
        if(service == null){service = new ClassServiceImpl();}
        return service;
    }

    @Override
    public Class create(Class cls){
        return this.repository.create(cls);
    }

    @Override
    public Class update(Class cls) {
        return this.repository.update(cls);
    }

    @Override
    public void delete(String classID){
        this.repository.delete(classID);
    }

    @Override
    public Class read(String classID) {
        return this.repository.read(classID);
    }

    @Override
    public Set<Class> getAll() {
        return this.repository.getAll();
    }

}

