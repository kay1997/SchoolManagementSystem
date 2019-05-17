package repository.admin.impl;

import domain.admin.Grade;
import repository.admin.GradeRepository;

import java.util.HashSet;
import java.util.Set;

public class GradeRepositoryImpl implements GradeRepository{

    private static GradeRepositoryImpl repository = null;
    private Set<Grade> grades;

    private GradeRepositoryImpl(){
        this.grades = new HashSet<>();
    }

    public static GradeRepositoryImpl getRepository(){
        if (repository == null) repository = new GradeRepositoryImpl();
        return repository;
    }


    public Grade create(Grade grade){
        this.grades.add(grade);
        return grade;
    }

    private Grade findGrade(String gradeNumber) {
        return this.grades.stream()
                .filter(grade -> grade.getGradeNumber().trim().equals(gradeNumber))
                .findAny()
                .orElse(null);
    }

    public Grade read(String gradeNumber){

        Grade grade = findGrade(gradeNumber);
        return grade;
    }

    public void delete(String gradeNumber) {
        Grade grade = findGrade(gradeNumber);
        if (grade != null) this.grades.remove(grade);

    }

    public Grade update(Grade grade) {
        Grade toDelete = findGrade(grade.getGradeNumber());
        if (toDelete != null) {
            this.grades.remove(toDelete);
            return create(grade);
        }
        return null;
    }



    public Set<Grade> getAll(){
        return this.grades;
    }
}
