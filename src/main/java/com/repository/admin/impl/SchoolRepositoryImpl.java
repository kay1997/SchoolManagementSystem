package com.repository.admin.impl;

import com.domain.admin.School;
import com.repository.admin.SchoolRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class SchoolRepositoryImpl implements SchoolRepository {
    private static SchoolRepositoryImpl repository = null;
    private Map<String, School> schools;

    private SchoolRepositoryImpl() {
        this.schools = new HashMap<>();
    }

    public static SchoolRepositoryImpl getRepository() {
        if (repository == null) repository = new SchoolRepositoryImpl();
        return repository;
    }

    @Override
    public Set<School> getAll() {
        Collection<School> schools = this.schools.values();
        Set<School> set = new HashSet<>();
        set.addAll(schools);
        return set;
    }

    @Override
    public School create(School school) {
        if (read(school.getSchoolCode()) == null) {
            this.schools.put(school.getSchoolCode(), school);
        }
        return school;
    }

    @Override
    public School read(String e) {
        return this.schools.get(e);
    }

    @Override
    public School update(School school) {
        if (read(school.getSchoolCode()) != null) {
            schools.replace(school.getSchoolCode(), school);
        }
        return school;
    }

    @Override
    public void delete(String e) {
        School school = read(e);
        this.schools.remove(e, school);
    }

}