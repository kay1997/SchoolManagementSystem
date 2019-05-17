package repository.equipment;

import domain.equipment.Printer;
import factory.equipment.PrinterFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repository.equipment.PrinterRepository;
import repository.equipment.impl.PrinterRepositoryImpl;

import java.util.Set;

public class PrinterRepositoryImplTest {

    private PrinterRepository repository;
    private Printer printer;

    private Printer getSavedPrinter() {
        Set<Printer> savedPrinters = this.repository.getAll();
        return savedPrinters.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = PrinterRepositoryImpl.getRepository();
        this.printer = PrinterFactory.getPrinter("321", "HP");
    }

    @Test
    public void a_create() {
        Printer created = this.repository.create(this.printer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.printer);
    }

    @Test
    public void b_read() {
        Printer savedPrinter = getSavedPrinter();
        System.out.println("In read, printer code = " + savedPrinter.getPrinterCode());
        Printer read = this.repository.read(savedPrinter.getPrinterCode());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPrinter, read);
    }

    @Test
    public void e_delete() {
        Printer savedPrinter = getSavedPrinter();
        this.repository.delete(savedPrinter.getPrinterCode());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newPrinterCode = "New Test Printer Code";
        Printer printer = new Printer.Builder().copy(getSavedPrinter()).printerCode(newPrinterCode).build();
        System.out.println("In update, about_to_updated = " + printer);
        Printer updated = this.repository.update(printer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newPrinterCode, updated.getPrinterCode());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Printer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
