package com.repository.admin.impl;

import com.domain.admin.Grade;
import com.repository.admin.GradeRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class GradeRepositoryImpl implements GradeRepository {
    private static GradeRepositoryImpl repository = null;
    private Map<String, Grade> grades;

    private GradeRepositoryImpl() {
        this.grades = new HashMap<>();
    }

    public static GradeRepositoryImpl getRepository() {
        if (repository == null) repository = new GradeRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Grade> getAll() {
        Collection<Grade> grades = this.grades.values();
        Set<Grade> set = new HashSet<>();
        set.addAll(grades);
        return set;
    }

    @Override
    public Grade create(Grade grade) {
        if (read(grade.getGradeID()) == null) {
            this.grades.put(grade.getGradeID(), grade);
        }
        return grade;
    }

    @Override
    public Grade read(String e) {
        return this.grades.get(e);
    }

    @Override
    public Grade update(Grade grade) {
        if (read(grade.getGradeID()) != null) {
            grades.replace(grade.getGradeID(), grade);
        }
        return grade;
    }

    @Override
    public void delete(String e) {
        Grade grade = read(e);
        this.grades.remove(e, grade);
    }

}