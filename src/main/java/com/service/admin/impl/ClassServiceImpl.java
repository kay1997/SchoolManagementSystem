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
    @Autowired
    @Qualifier("InMemory")
    private ClassServiceImpl service = null;
    private ClassRepository repository;

    private ClassServiceImpl(){
        this.repository = ClassRepositoryImpl.getRepository();
    }

    public ClassService getService(){
        if (service == null) service = new ClassServiceImpl();
        return service;
    }

    @Override
    public Class create(Class oneClass) {
        return this.repository.create(oneClass);
    }

    @Override
    public Class update(Class oneClass) {
        return this.repository.update(oneClass);
    }

    @Override
    public void delete(String classGroup) {
        this.repository.delete(classGroup);
    }

    @Override
    public Class read(String classGroup) {
        return this.repository.read(classGroup);
    }

    @Override
    public Set<Class> getAll() {
        return this.repository.getAll();
    }

}
