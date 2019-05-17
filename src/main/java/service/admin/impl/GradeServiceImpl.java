package service.admin.impl;

import domain.admin.Grade;
import org.springframework.stereotype.Service;
import repository.admin.GradeRepository;
import repository.admin.impl.GradeRepositoryImpl;
import service.admin.GradeService;

import java.util.Set;

@Service
public class GradeServiceImpl implements GradeService{

    private GradeServiceImpl service = null;
    private GradeRepository repository;

    private GradeServiceImpl(){
        this.repository = GradeRepositoryImpl.getRepository();
    }

    public GradeService getService(){
        if (service == null) service = new GradeServiceImpl();
        return service;
    }

    @Override
    public Grade create(Grade grade) {
        return this.repository.create(grade);
    }

    @Override
    public Grade update(Grade grade) {
        return this.repository.update(grade);
    }

    @Override
    public void delete(String gradeNumber) {
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
