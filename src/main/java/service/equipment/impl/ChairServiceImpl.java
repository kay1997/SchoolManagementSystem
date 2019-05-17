package service.equipment.impl;

import domain.equipment.Chair;
import org.springframework.stereotype.Service;
import repository.equipment.ChairRepository;

import repository.equipment.impl.ChairRepositoryImpl;
import service.equipment.ChairService;

import java.util.Set;

@Service
public class ChairServiceImpl implements ChairService {

    private ChairServiceImpl service = null;
    private ChairRepository repository;

    private ChairServiceImpl(){
        this.repository = ChairRepositoryImpl.getRepository();
    }

    public ChairService getService(){
        if (service == null) service = new ChairServiceImpl();
        return service;
    }

    @Override
    public Chair create(Chair chair) {
        return this.repository.create(chair);
    }

    @Override
    public Chair update(Chair chair) {
        return this.repository.update(chair);
    }

    @Override
    public void delete(String chairNumber) {
        this.repository.delete(chairNumber);
    }

    @Override
    public Chair read(String chairNumber) {
        return this.repository.read(chairNumber);
    }

    @Override
    public Set<Chair> getAll() {
        return this.repository.getAll();
    }

}
