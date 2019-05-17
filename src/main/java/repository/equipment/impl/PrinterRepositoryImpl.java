package repository.equipment.impl;

import domain.equipment.Printer;
import repository.equipment.PrinterRepository;

import java.util.HashSet;
import java.util.Set;

public class PrinterRepositoryImpl implements PrinterRepository{

    private static PrinterRepositoryImpl repository = null;
    private Set<Printer> printers;

    private PrinterRepositoryImpl(){
        this.printers = new HashSet<>();
    }

    public static PrinterRepositoryImpl getRepository(){
        if (repository == null) repository = new PrinterRepositoryImpl();
        return repository;
    }


    public Printer create(Printer printer){
        this.printers.add(printer);
        return printer;
    }

    private Printer findPrinter(String printerCode) {
        return this.printers.stream()
                .filter(printer -> printer.getPrinterCode().trim().equals(printerCode))
                .findAny()
                .orElse(null);
    }

    public Printer read(String printerCode){

        Printer printer = findPrinter(printerCode);
        return printer;
    }

    public void delete(String printerCode) {
        Printer printer = findPrinter(printerCode);
        if (printer != null) this.printers.remove(printer);

    }

    public Printer update(Printer printer) {
        Printer toDelete = findPrinter(printer.getPrinterCode());
        if (toDelete != null) {
            this.printers.remove(toDelete);
            return create(printer);
        }
        return null;
    }

    public Set<Printer> getAll(){
        return this.printers;
    }
}