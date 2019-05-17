package repository.admin.impl;

import domain.admin.School;
import repository.admin.SchoolRepository;

import java.util.HashSet;
import java.util.Set;

public class SchoolRepositoryImpl implements SchoolRepository{

    private static SchoolRepositoryImpl repository = null;
    private Set<School> schools;

    private SchoolRepositoryImpl(){
        this.schools = new HashSet<>();
    }

    public static SchoolRepositoryImpl getRepository(){
        if (repository == null) repository = new SchoolRepositoryImpl();
        return repository;
    }

    public School create(School school){
        this.schools.add(school);
        return school;
    }

    private School findSchool(String schoolCode) {
        return this.schools.stream()
                .filter(school -> school.getSchoolCode().trim().equals(schoolCode))
                .findAny()
                .orElse(null);
    }

    public School read(String schoolCode){

        School school = findSchool(schoolCode);
        return school;
    }

    public void delete(String schoolCode) {
        School school = findSchool(schoolCode);
        if (school != null) this.schools.remove(school);

    }

    public School update(School school) {
        School toDelete = findSchool(school.getSchoolCode());
        if (toDelete != null) {
            this.schools.remove(toDelete);
            return create(school);
        }
        return null;
    }



    public Set<School> getAll(){
        return this.schools;
    }
}
