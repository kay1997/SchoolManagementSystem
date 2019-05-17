package repository.equipment.impl;

import domain.equipment.Computer;
import repository.equipment.ComputerRepository;

import java.util.HashSet;
import java.util.Set;

public class ComputerRepositoryImpl implements ComputerRepository{
    private static ComputerRepositoryImpl repository = null;
    private Set<Computer> computers;

    private ComputerRepositoryImpl(){
        this.computers = new HashSet<>();
    }

    public static ComputerRepositoryImpl getRepository(){
        if (repository == null) repository = new ComputerRepositoryImpl();
        return repository;
    }


    public Computer create(Computer computer){
        this.computers.add(computer);
        return computer;
    }

    private Computer findComputer(String computerNumber) {
        return this.computers.stream()
                .filter(computer -> computer.getComputerNumber().trim().equals(computerNumber))
                .findAny()
                .orElse(null);
    }

    public Computer read(String computerNumber){

        Computer computer = findComputer(computerNumber);
        return computer;
    }

    public void delete(String computerNumber) {
        Computer computer = findComputer(computerNumber);
        if (computer != null) this.computers.remove(computer);

    }

    public Computer update(Computer computer) {
        Computer toDelete = findComputer(computer.getComputerNumber());
        if (toDelete != null) {
            this.computers.remove(toDelete);
            return create(computer);
        }
        return null;
    }

    public Set<Computer> getAll(){
        return this.computers;
    }
}

