package service.admin.impl;

import domain.admin.Class;
import org.springframework.stereotype.Service;
import repository.admin.ClassRepository;
import repository.admin.impl.ClassRepositoryImpl;
import service.admin.ClassService;

import java.util.Set;

@Service
public class ClassServiceImpl implements ClassService {

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
