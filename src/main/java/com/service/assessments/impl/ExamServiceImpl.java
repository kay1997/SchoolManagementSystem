package com.service.assessments.impl;

import com.domain.assessments.Exam;
import com.service.assessments.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.assessments.ExamRepository;
import com.repository.assessments.impl.ExamRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class ExamServiceImpl implements ExamService {
    private static ExamServiceImpl service;
    private ExamRepository repository;

    private ExamServiceImpl(){this.repository = ExamRepositoryImpl.getRepository();}

    public static ExamServiceImpl getService()
    {
        if(service == null){service = new ExamServiceImpl();}
        return service;
    }

    @Override
    public Exam create(Exam exam){
        return this.repository.create(exam);
    }

    @Override
    public Exam update(Exam exam) {
        return this.repository.update(exam);
    }

    @Override
    public void delete(String examPaperNumber){
        this.repository.delete(examPaperNumber);
    }

    @Override
    public Exam read(String examPaperNumber) {
        return this.repository.read(examPaperNumber);
    }

    @Override
    public Set<Exam> getAll() {
        return this.repository.getAll();
    }

}