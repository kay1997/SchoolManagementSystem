package repository.people.impl;

import domain.people.Principle;
import repository.people.PrincipleRepository;

import java.util.HashSet;
import java.util.Set;

public class PrincipleRepositoryImpl implements PrincipleRepository {

    private static PrincipleRepositoryImpl repository = null;
    private Set<Principle> principles;

    private PrincipleRepositoryImpl(){
        this.principles = new HashSet<>();
    }

    public static PrincipleRepositoryImpl getRepository(){
        if (repository == null) repository = new PrincipleRepositoryImpl();
        return repository;
    }


    public Principle create(Principle principle){
        this.principles.add(principle);
        return principle;
    }

    private Principle findPrinciple(String principleIDNumber) {
        return this.principles.stream()
                .filter(principle -> principle.getPrincipleIDNumber().trim().equals(principleIDNumber))
                .findAny()
                .orElse(null);
    }

    public Principle read(String principleIDNumber){

        Principle principle = findPrinciple(principleIDNumber);
        return principle;
    }

    public void delete(String principleIDNumber) {
        Principle principle = findPrinciple(principleIDNumber);
        if (principle != null) this.principles.remove(principle);

    }

    public Principle update(Principle principle) {
        Principle toDelete = findPrinciple(principle.getPrincipleIDNumber());
        if (toDelete != null) {
            this.principles.remove(toDelete);
            return create(principle);
        }
        return null;
    }



    public Set<Principle> getAll(){
        return this.principles;
    }
}