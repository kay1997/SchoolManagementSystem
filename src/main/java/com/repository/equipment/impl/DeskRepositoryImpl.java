package com.repository.equipment.impl;

import com.domain.equipment.Desk;
import com.repository.equipment.DeskRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("InMemory")
public class DeskRepositoryImpl implements DeskRepository {

    private static DeskRepositoryImpl repository = null;
    private Set<Desk> desks;

    private DeskRepositoryImpl(){
        this.desks = new HashSet<>();
    }

    public static DeskRepositoryImpl getRepository(){
        if (repository == null) repository = new DeskRepositoryImpl();
        return repository;
    }


    public Desk create(Desk desk){
        this.desks.add(desk);
        return desk;
    }

    private Desk findDesk(String deskNumber) {
        return this.desks.stream()
                .filter(desk -> desk.getDeskNumber().trim().equals(deskNumber))
                .findAny()
                .orElse(null);
    }

    public Desk read(String deskNumber){

        Desk desk = findDesk(deskNumber);
        return desk;
    }

    public void delete(String deskNumber) {
        Desk desk = findDesk(deskNumber);
        if (desk != null) this.desks.remove(desk);

    }

    public Desk update(Desk desk) {
        Desk toDelete = findDesk(desk.getDeskNumber());
        if (toDelete != null) {
            this.desks.remove(toDelete);
            return create(desk);
        }
        return null;
    }

    public Set<Desk> getAll(){
        return this.desks;
    }
}
