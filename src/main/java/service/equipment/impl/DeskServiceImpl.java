package service.equipment.impl;

import domain.equipment.Desk;
import org.springframework.stereotype.Service;
import repository.equipment.DeskRepository;
import repository.equipment.impl.DeskRepositoryImpl;
import service.equipment.DeskService;

import java.util.Set;

@Service
public class DeskServiceImpl implements DeskService {

    private DeskServiceImpl service = null;
    private DeskRepository repository;

    private DeskServiceImpl(){
        this.repository = DeskRepositoryImpl.getRepository();
    }

    public DeskService getService(){
        if (service == null) service = new DeskServiceImpl();
        return service;
    }

    @Override
    public Desk create(Desk desk) {
        return this.repository.create(desk);
    }

    @Override
    public Desk update(Desk desk) {
        return this.repository.update(desk);
    }

    @Override
    public void delete(String deskNumber) {
        this.repository.delete(deskNumber);
    }

    @Override
    public Desk read(String deskNumber) {
        return this.repository.read(deskNumber);
    }

    @Override
    public Set<Desk> getAll() {
        return this.repository.getAll();
    }

}
