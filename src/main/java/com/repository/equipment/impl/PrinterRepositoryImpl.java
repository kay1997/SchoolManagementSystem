package com.repository.equipment.impl;

import com.domain.equipment.Printer;
import com.repository.equipment.PrinterRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class PrinterRepositoryImpl implements PrinterRepository {

    private static PrinterRepositoryImpl repository = null;
    private Map<String, Printer> printers;

    private PrinterRepositoryImpl() {
        this.printers = new HashMap<>();
    }

    public static PrinterRepositoryImpl getRepository() {
        if (repository == null) repository = new PrinterRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Printer> getAll() {
        Collection<Printer> printers = this.printers.values();
        Set<Printer> set = new HashSet<>();
        set.addAll(printers);
        return set;
    }

    @Override
    public Printer create(Printer printer) {
        if (read(printer.getPrinterCode()) == null) {
            this.printers.put(printer.getPrinterCode(), printer);
        }
        return printer;
    }

    @Override
    public Printer read(String e) {
        return this.printers.get(e);
    }

    @Override
    public Printer update(Printer printer) {
        if (read(printer.getPrinterCode()) != null) {
            printers.replace(printer.getPrinterCode(), printer);
        }
        return printer;
    }

    @Override
    public void delete(String e) {
        Printer printer = read(e);
        this.printers.remove(e, printer);
    }

}