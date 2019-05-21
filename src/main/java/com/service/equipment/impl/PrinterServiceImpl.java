package com.service.equipment.impl;

import com.domain.equipment.Printer;
import com.service.equipment.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.equipment.PrinterRepository;
import com.repository.equipment.impl.PrinterRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class PrinterServiceImpl implements PrinterService {
    @Autowired
    @Qualifier("InMemory")
    private PrinterServiceImpl service = null;
    private PrinterRepository repository;

    private PrinterServiceImpl() {
        this.repository = PrinterRepositoryImpl.getRepository();
    }

    public PrinterService getService() {
        if (service == null) service = new PrinterServiceImpl();
        return service;
    }

    @Override
    public Printer create(Printer printer) {
        return this.repository.create(printer);
    }

    @Override
    public Printer update(Printer printer) {
        return this.repository.update(printer);
    }

    @Override
    public void delete(String printerCode) {
        this.repository.delete(printerCode);
    }

    @Override
    public Printer read(String printerCode) {
        return this.repository.read(printerCode);
    }

    @Override
    public Set<Printer> getAll() {
        return this.repository.getAll();
    }

}