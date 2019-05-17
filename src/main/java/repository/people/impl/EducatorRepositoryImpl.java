package repository.people.impl;

import domain.people.Educator;
import repository.people.EducatorRepository;

import java.util.HashSet;
import java.util.Set;

public class EducatorRepositoryImpl implements EducatorRepository {

    private static EducatorRepositoryImpl repository = null;
    private Set<Educator> educators;

    private EducatorRepositoryImpl(){
        this.educators = new HashSet<>();
    }

    public static EducatorRepositoryImpl getRepository(){
        if (repository == null) repository = new EducatorRepositoryImpl();
        return repository;
    }


    public Educator create(Educator educator){
        this.educators.add(educator);
        return educator;
    }

    private Educator findEducator(String educatorIDNumber) {
        return this.educators.stream()
                .filter(educator -> educator.getEducatorIDNumber().trim().equals(educatorIDNumber))
                .findAny()
                .orElse(null);
    }

    public Educator read(String educatorIDNumber){

        Educator educator = findEducator(educatorIDNumber);
        return educator;
    }

    public void delete(String educatorIDNumber) {
        Educator educator = findEducator(educatorIDNumber);
        if (educator != null) this.educators.remove(educator);

    }

    public Educator update(Educator educator) {
        Educator toDelete = findEducator(educator.getEducatorIDNumber());
        if (toDelete != null) {
            this.educators.remove(toDelete);
            return create(educator);
        }
        return null;
    }



    public Set<Educator> getAll(){
        return this.educators;
    }
}