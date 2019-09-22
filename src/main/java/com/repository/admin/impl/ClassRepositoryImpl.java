package com.repository.admin.impl;

import com.domain.admin.Class;
import com.repository.admin.ClassRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class ClassRepositoryImpl implements ClassRepository {

    private static ClassRepositoryImpl repository = null;
    private Map<String, Class> clss;

    private ClassRepositoryImpl() {
        this.clss = new HashMap<>();
    }

    public static ClassRepositoryImpl getRepository() {
        if (repository == null) repository = new ClassRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Class> getAll() {
        Collection<Class> clss = this.clss.values();
        Set<Class> set = new HashSet<>();
        set.addAll(clss);
        return set;
    }

    @Override
    public Class create(Class cls) {
        if (read(cls.getClassID()) == null) {
            this.clss.put(cls.getClassID(), cls);
        }
        return cls;
    }

    @Override
    public Class read(String e) {
        return this.clss.get(e);
    }

    @Override
    public Class update(Class cls) {
        if (read(cls.getClassID()) != null) {
            clss.replace(cls.getClassID(), cls);
        }
        return cls;
    }

    @Override
    public void delete(String e) {
        Class cls = read(e);
        this.clss.remove(e, cls);
    }

}