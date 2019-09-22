package com.repository.admin.impl;

import com.domain.admin.Subject;
import com.repository.admin.SubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class SubjectRepositoryImpl implements SubjectRepository {

    private static SubjectRepositoryImpl repository = null;
    private Map<String, Subject> subjects;

    private SubjectRepositoryImpl() {
        this.subjects = new HashMap<>();
    }

    public static SubjectRepositoryImpl getRepository() {
        if (repository == null) repository = new SubjectRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Subject> getAll() {
        Collection<Subject> subjects = this.subjects.values();
        Set<Subject> set = new HashSet<>();
        set.addAll(subjects);
        return set;
    }

    @Override
    public Subject create(Subject subject) {
        if (read(subject.getSubjectCode()) == null) {
            this.subjects.put(subject.getSubjectCode(), subject);
        }
        return subject;
    }

    @Override
    public Subject read(String e) {
        return this.subjects.get(e);
    }

    @Override
    public Subject update(Subject subject) {
        if (read(subject.getSubjectCode()) != null) {
            subjects.replace(subject.getSubjectCode(), subject);
        }
        return subject;
    }

    @Override
    public void delete(String e) {
        Subject subject = read(e);
        this.subjects.remove(e, subject);
    }

}