package service.assessments.impl;

import domain.assessments.Exam;
import org.springframework.stereotype.Service;
import repository.assessments.ExamRepository;
import repository.assessments.impl.ExamRepositoryImpl;
import service.assessments.ExamService;

import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

    private ExamServiceImpl service = null;
    private ExamRepository repository;

    private ExamServiceImpl(){
        this.repository = ExamRepositoryImpl.getRepository();
    }

    public ExamService getService(){
        if (service == null) service = new ExamServiceImpl();
        return service;
    }

    @Override
    public Exam create(Exam exam) {
        return this.repository.create(exam);
    }

    @Override
    public Exam update(Exam exam) {
        return this.repository.update(exam);
    }

    @Override
    public void delete(String examPaperNumber) {
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