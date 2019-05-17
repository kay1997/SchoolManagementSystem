package repository.admin.impl;

import domain.admin.Subject;
import repository.admin.SubjectRepository;

import java.util.HashSet;
import java.util.Set;

public class SubjectRepositoryImpl implements SubjectRepository{

    private static SubjectRepositoryImpl repository = null;
    private Set<Subject> subjects;

    private SubjectRepositoryImpl(){
        this.subjects = new HashSet<>();
    }

    private Subject findSubject(String subjectCode) {
        return this.subjects.stream()
                .filter(subject -> subject.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static SubjectRepositoryImpl getRepository(){
        if (repository == null) repository = new SubjectRepositoryImpl();
        return repository;
    }


    public Subject create(Subject subject){
        this.subjects.add(subject);
        return subject;
    }

    public Subject read(final String subjectCode){
        Subject subject = findSubject(subjectCode);
        return subject;
    }

    public void delete(String subjectCode) {
        Subject subject = findSubject(subjectCode);
        if (subject != null) this.subjects.remove(subject);

    }

    public Subject update(Subject subject){
        Subject toDelete = findSubject(subject.getSubjectCode());
        if(toDelete != null) {
            this.subjects.remove(toDelete);
            return create(subject);
        }
        return null;
    }


    public Set<Subject> getAll(){
        return this.subjects;
    }
}
