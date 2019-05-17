package repository.people.impl;

import domain.people.Security;
import repository.people.SecurityRepository;

import java.util.HashSet;
import java.util.Set;

public class SecurityRepositoryImpl implements SecurityRepository {

    private static SecurityRepositoryImpl repository = null;
    private Set<Security> securities;

    private SecurityRepositoryImpl(){
        this.securities = new HashSet<>();
    }

    public static SecurityRepositoryImpl getRepository(){
        if (repository == null) repository = new SecurityRepositoryImpl();
        return repository;
    }


    public Security create(Security security){
        this.securities.add(security);
        return security;
    }

    private Security findSecurity(String securityIDNumber) {
        return this.securities.stream()
                .filter(security -> security.getSecurityIDNumber().trim().equals(securityIDNumber))
                .findAny()
                .orElse(null);
    }

    public Security read(String securityIDNumber){

        Security security = findSecurity(securityIDNumber);
        return security;
    }

    public void delete(String securityIDNumber) {
        Security security = findSecurity(securityIDNumber);
        if (security != null) this.securities.remove(security);

    }

    public Security update(Security security) {
        Security toDelete = findSecurity(security.getSecurityIDNumber());
        if (toDelete != null) {
            this.securities.remove(toDelete);
            return create(security);
        }
        return null;
    }



    public Set<Security> getAll(){
        return this.securities;
    }
}

