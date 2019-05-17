package service.equipment.impl;

import domain.equipment.Stationery;
import org.springframework.stereotype.Service;
import repository.equipment.StationeryRepository;
import repository.equipment.impl.StationeryRepositoryImpl;
import service.equipment.StationeryService;

import java.util.Set;

@Service
public class StationeryServiceImpl implements StationeryService {

    private StationeryServiceImpl service = null;
    private StationeryRepository repository;

    private StationeryServiceImpl() {
        this.repository = StationeryRepositoryImpl.getRepository();
    }

    public StationeryService getService() {
        if (service == null) service = new StationeryServiceImpl();
        return service;
    }

    @Override
    public Stationery create(Stationery stationery) {
        return this.repository.create(stationery);
    }

    @Override
    public Stationery update(Stationery stationery) {
        return this.repository.update(stationery);
    }

    @Override
    public void delete(String stationeryCode) {
        this.repository.delete(stationeryCode);
    }

    @Override
    public Stationery read(String stationeryCode) {
        return this.repository.read(stationeryCode);
    }

    @Override
    public Set<Stationery> getAll() {
        return this.repository.getAll();
    }
}