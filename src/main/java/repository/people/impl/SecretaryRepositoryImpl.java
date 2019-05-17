package repository.people.impl;

import domain.people.Secretary;
import repository.people.SecretaryRepository;

import java.util.HashSet;
import java.util.Set;

public class SecretaryRepositoryImpl implements SecretaryRepository
{
    private static SecretaryRepositoryImpl repository = null;
    private Set<Secretary> secretaries;

    private SecretaryRepositoryImpl(){
        this.secretaries = new HashSet<>();
    }

    public static SecretaryRepositoryImpl getRepository(){
        if (repository == null) repository = new SecretaryRepositoryImpl();
        return repository;
    }


    public Secretary create(Secretary secretary){
        this.secretaries.add(secretary);
        return secretary;
    }

    private Secretary findSecretary(String secretaryIDNumber) {
        return this.secretaries.stream()
                .filter(secretary -> secretary.getSecretaryIDNumber().trim().equals(secretaryIDNumber))
                .findAny()
                .orElse(null);
    }

    public Secretary read(String secretaryIDNumber){

        Secretary secretary = findSecretary(secretaryIDNumber);
        return secretary;
    }

    public void delete(String secretaryIDNumber) {
        Secretary secretary = findSecretary(secretaryIDNumber);
        if (secretary != null) this.secretaries.remove(secretary);

    }

    public Secretary update(Secretary secretary) {
        Secretary toDelete = findSecretary(secretary.getSecretaryIDNumber());
        if (toDelete != null) {
            this.secretaries.remove(toDelete);
            return create(secretary);
        }
        return null;
    }


    public Set<Secretary> getAll(){
        return this.secretaries;
    }
}

