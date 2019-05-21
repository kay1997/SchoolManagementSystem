package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Printer;
import com.factory.equipment.PrinterFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PrinterRepositoryImplTest {
    @Autowired
    private PrinterRepository repository;
    private String printerCode = null;

    @Test
    public void CreatePrinterTest() throws IOException {
        Printer printer = PrinterFactory.getPrinter("00234", "HP");
        Printer result = repository.create(printer);
        printerCode = result.getPrinterCode();
        Assert.assertNotNull(printer);
    }

    @Test
    public void GetPrinterTest() throws IOException {

        Printer printer = repository.read(printerCode);
        Assert.assertNotNull(printer);
    }
}
