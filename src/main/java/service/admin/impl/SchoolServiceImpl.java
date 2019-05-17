package service.admin.impl;

import domain.admin.School;
import org.springframework.stereotype.Service;
import repository.admin.SchoolRepository;
import repository.admin.impl.SchoolRepositoryImpl;
import service.admin.SchoolService;

import java.util.Set;

@Service
public class SchoolServiceImpl implements SchoolService {

    private SchoolServiceImpl service = null;
    private SchoolRepository repository;

    private SchoolServiceImpl() {
        this.repository = SchoolRepositoryImpl.getRepository();
    }

    public SchoolService getService() {
        if (service == null) service = new SchoolServiceImpl();
        return service;
    }

    @Override
    public School create(School school) {
        return this.repository.create(school);
    }

    @Override
    public School update(School school) {
        return this.repository.update(school);
    }

    @Override
    public void delete(String schoolCode) {
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
