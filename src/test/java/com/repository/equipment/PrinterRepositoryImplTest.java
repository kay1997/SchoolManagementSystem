package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Printer;
import com.factory.equipment.PrinterFactory;
import com.repository.equipment.impl.PrinterRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PrinterRepositoryImplTest {
    PrinterRepositoryImpl repository;
    Printer printer;

    @Before
    public void setUp() throws Exception {

        repository = PrinterRepositoryImpl.getRepository();
        printer = PrinterFactory.getPrinter("002", "HP");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(printer);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(printer);
        assertNotNull(repository.read(printer.getPrinterCode()));
        System.out.println("Created\n" + repository.read(printer.getPrinterCode()));
    }

    @Test
    public void read() {

        repository.create(printer);

        Printer printers = repository.read(printer.getPrinterCode());

        assertEquals(printer, printers);
    }

    @Test
    public void update() {

        repository.create(printer);

        Printer updatedPrinter = PrinterFactory.getPrinter("3",  "Lexmark");

        repository.update(updatedPrinter);

        Assert.assertNotEquals(printer.getPrinterName(), updatedPrinter.getPrinterName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}