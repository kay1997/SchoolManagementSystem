package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Printer;
import com.factory.equipment.PrinterFactory;
import com.service.equipment.impl.PrinterServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.PrinterRepository;
import com.repository.equipment.impl.PrinterRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class PrinterServiceTest {

    PrinterServiceImpl service;
    Printer printer;

    @Before
    public void setUp() throws Exception {
        service = PrinterServiceImpl.getService();
        printer = PrinterFactory.getPrinter("12345", "Canon");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(printer);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(printer);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @Test
    public void update() {
        service.create(printer);
        System.out.println(service.read("12345"));

        Printer printerUpdated = PrinterFactory.getPrinter("12345", "HP");
        service.update(printerUpdated);

        Printer pri = service.read("12345");
        Assert.assertNotEquals(printer.getPrinterName(), pri.getPrinterName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(printer.getPrinterCode()));
        System.out.println("Delete\n" + service.read(printer.getPrinterCode()));
    }

}