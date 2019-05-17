package service.equipment.impl;

import domain.equipment.Computer;
import org.springframework.stereotype.Service;
import repository.equipment.ComputerRepository;
import repository.equipment.impl.ComputerRepositoryImpl;
import service.equipment.ComputerService;

import java.util.Set;

@Service
public class ComputerServiceImpl implements ComputerService {

    private ComputerServiceImpl service = null;
    private ComputerRepository repository;

    private ComputerServiceImpl() {
        this.repository = ComputerRepositoryImpl.getRepository();
    }

    public ComputerService getService() {
        if (service == null) service = new ComputerServiceImpl();
        return service;
    }

    @Override
    public Computer create(Computer computer) {
        return this.repository.create(computer);
    }

    @Override
    public Computer update(Computer computer) {
        return this.repository.update(computer);
    }

    @Override
    public void delete(String computerNumber) {
        this.repository.delete(computerNumber);
    }

    @Override
    public Computer read(String computerNumber) {
        return this.repository.read(computerNumber);
    }

    @Override
    public Set<Computer> getAll() {
        return this.repository.getAll();
    }

}