package service.equipment.impl;

import domain.equipment.Printer;
import org.springframework.stereotype.Service;
import repository.equipment.PrinterRepository;
import repository.equipment.impl.PrinterRepositoryImpl;
import service.equipment.PrinterService;

import java.util.Set;

@Service
public class PrinterServiceImpl implements PrinterService {

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