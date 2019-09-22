package com.service.admin.impl;

import com.domain.admin.Subject;
import com.service.admin.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.admin.SubjectRepository;
import com.repository.admin.impl.SubjectRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class SubjectServiceImpl implements SubjectService {
    private static SubjectServiceImpl service;
    private SubjectRepository repository;

    private SubjectServiceImpl(){this.repository = SubjectRepositoryImpl.getRepository();}

    public static SubjectServiceImpl getService()
    {
        if(service == null){service = new SubjectServiceImpl();}
        return service;
    }

    @Override
    public Subject create(Subject subject){
        return this.repository.create(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.update(subject);
    }

    @Override
    public void delete(String subjectCode){
        this.repository.delete(subjectCode);
    }

    @Override
    public Subject read(String subjectCode) {
        return this.repository.read(subjectCode);
    }

    @Override
    public Set<Subject> getAll() {
        return this.repository.getAll();
    }

}
