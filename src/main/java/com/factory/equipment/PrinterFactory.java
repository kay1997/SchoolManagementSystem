package com.factory.equipment;

import com.domain.equipment.Printer;

public class PrinterFactory {

    public static Printer getPrinter(String printerCode, String printerName) {
        return new Printer.Builder().printerCode(printerCode).printerName(printerName).build();
    }
}