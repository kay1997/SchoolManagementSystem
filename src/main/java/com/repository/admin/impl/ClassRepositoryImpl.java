package com.repository.admin.impl;

import com.domain.admin.Class;
import com.repository.admin.ClassRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class ClassRepositoryImpl implements ClassRepository {

        private static ClassRepositoryImpl repository = null;
        private Set<Class> classes;

        private ClassRepositoryImpl(){
            this.classes = new HashSet<>();
        }

        public static ClassRepositoryImpl getRepository(){
            if (repository == null) repository = new ClassRepositoryImpl();
            return repository;
        }


        public Class create(Class oneClass){
            this.classes.add(oneClass);
            return oneClass;
        }

    private Class findClass(String classGroup) {
        return this.classes.stream()
                .filter(oneClass -> oneClass.getClassGroup().trim().equals(classGroup))
                .findAny()
                .orElse(null);
    }

    public Class read(String classGroup){

        Class oneClass = findClass(classGroup);
        return oneClass;
    }

    public void delete(String classGroup) {
        Class oneClass = findClass(classGroup);
        if (oneClass != null) this.classes.remove(oneClass);

    }

    public Class update(Class oneClass) {
        Class toDelete = findClass(oneClass.getClassGroup());
        if (toDelete != null) {
            this.classes.remove(toDelete);
            return create(oneClass);
        }
        return null;
    }



    public Set<Class> getAll(){
            return this.classes;
        }
    }

