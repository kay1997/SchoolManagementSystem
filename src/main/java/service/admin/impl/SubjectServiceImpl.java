package service.admin.impl;

import domain.admin.Subject;
import org.springframework.stereotype.Service;
import repository.admin.SubjectRepository;
import repository.admin.impl.SubjectRepositoryImpl;
import service.admin.SubjectService;

import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectServiceImpl service = null;
    private SubjectRepository repository;

    private SubjectServiceImpl() {
        this.repository = SubjectRepositoryImpl.getRepository();
    }

    public SubjectService getService() {
        if (service == null) service = new SubjectServiceImpl();
        return service;
    }

    @Override
    public Subject create(Subject subject) {
        return this.repository.create(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.update(subject);
    }

    @Override
    public void delete(String subjectCode) {
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
