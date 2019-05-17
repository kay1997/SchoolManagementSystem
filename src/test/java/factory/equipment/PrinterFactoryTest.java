package factory.equipment;

import factory.equipment.PrinterFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.equipment.Printer;

public class PrinterFactoryTest {


    @Test
    public void getPrinterCode() {

        String id = "987654321";
        String name = "HP";


        Printer printer = PrinterFactory.getPrinter(id, name);
        System.out.println(printer);
        Assert.assertNotNull(printer.getPrinterCode());
    }
}