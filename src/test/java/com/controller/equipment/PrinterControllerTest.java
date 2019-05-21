package com.controller.equipment;

import com.domain.equipment.Printer;
import com.factory.equipment.PrinterFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PrinterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/printer";

    @Test
    public void testGetAllPrinters() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetPrinterByCode() {
        Printer printer = restTemplate.getForObject(baseURL + "/printer/1", Printer.class);
        System.out.println(printer.getPrinterCode());
        assertNotNull(printer);
    }

    @Ignore
    public void testCreatePrinter() {
        Printer printer = PrinterFactory.getPrinter("3456","Hp");
        ResponseEntity<Printer> postResponse = restTemplate.postForEntity(baseURL + "/create", printer, Printer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdatePrinter() {
        int id = 1;
        Printer printer = restTemplate.getForObject(baseURL + "/printer/" + id, Printer.class);

        restTemplate.put(baseURL + "/printers/" + id, printer);
        Printer updatedPrinter = restTemplate.getForObject(baseURL + "/Printer/" + id, Printer.class);
        assertNotNull(updatedPrinter);
    }

    @Ignore
    public void testDeletePrinter() {
        int id = 2;
        Printer printer = restTemplate.getForObject(baseURL + "/printers/" + id, Printer.class);
        assertNotNull(printer);
        restTemplate.delete(baseURL + "/printers/" + id);
        try {
            printer = restTemplate.getForObject(baseURL + "/printers/" + id, Printer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

