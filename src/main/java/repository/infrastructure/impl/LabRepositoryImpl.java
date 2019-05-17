package repository.infrastructure.impl;

import domain.infrastructure.Lab;
import repository.infrastructure.LabRepository;

import java.util.HashSet;
import java.util.Set;

public class LabRepositoryImpl implements LabRepository
{
    private static LabRepositoryImpl repository = null;
    private Set<Lab> labs;

    private LabRepositoryImpl(){
        this.labs = new HashSet<>();
    }

    public static LabRepositoryImpl getRepository(){
        if (repository == null) repository = new LabRepositoryImpl();
        return repository;
    }


    public Lab create(Lab lab){
        this.labs.add(lab);
        return lab;
    }

    private Lab findLab(String labNumber) {
        return this.labs.stream()
                .filter(lab -> lab.getLabNumber().trim().equals(labNumber))
                .findAny()
                .orElse(null);
    }

    public Lab read(String labNumber){

        Lab lab = findLab(labNumber);
        return lab;
    }

    public void delete(String labNumber) {
        Lab lab = findLab(labNumber);
        if (lab != null) this.labs.remove(lab);

    }

    public Lab update(Lab lab) {
        Lab toDelete = findLab(lab.getLabNumber());
        if (toDelete != null) {
            this.labs.remove(toDelete);
            return create(lab);
        }
        return null;
    }

    public Set<Lab> getAll(){
        return this.labs;
    }
}
