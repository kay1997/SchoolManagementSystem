package com.repository.equipment.impl;

import com.domain.equipment.Computer;
import com.repository.equipment.ComputerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class ComputerRepositoryImpl implements ComputerRepository {
    private static ComputerRepositoryImpl repository = null;
    private Map<String, Computer> computers;

    private ComputerRepositoryImpl() {
        this.computers = new HashMap<>();
    }

    public static ComputerRepositoryImpl getRepository() {
        if (repository == null) repository = new ComputerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Computer> getAll() {
        Collection<Computer> computers = this.computers.values();
        Set<Computer> set = new HashSet<>();
        set.addAll(computers);
        return set;
    }

    @Override
    public Computer create(Computer computer) {
        if (read(computer.getComputerNumber()) == null) {
            this.computers.put(computer.getComputerNumber(), computer);
        }
        return computer;
    }

    @Override
    public Computer read(String e) {
        return this.computers.get(e);
    }

    @Override
    public Computer update(Computer computer) {
        if (read(computer.getComputerNumber()) != null) {
            computers.replace(computer.getComputerNumber(), computer);
        }
        return computer;
    }

    @Override
    public void delete(String e) {
        Computer computer = read(e);
        this.computers.remove(e, computer);
    }

}