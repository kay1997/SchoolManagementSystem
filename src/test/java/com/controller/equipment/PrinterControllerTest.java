package com.controller.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Printer;
import com.factory.equipment.PrinterFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SchoolManagementSystemApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrinterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/printer";

    @Test
    public void a_create() {

        Printer printer = PrinterFactory.getPrinter("97", "Lexmark");
        printer.setPrinterCode("123");

        ResponseEntity<Printer> postResponse = restTemplate.postForEntity(baseURL + "/new", printer, Printer.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Printer printer = restTemplate.getForObject(baseURL + "/find/" + "123", Printer.class);

        assertNotNull(printer);
    }

    @Test
    public void c_update() {

        int id = 1;
        Printer printer = restTemplate.getForObject(baseURL + "/find/" + "123", Printer.class);
        printer.setPrinterName("HP");

        restTemplate.put(baseURL + "/update/" + "123", printer);

        Printer updatedPrinter = restTemplate.getForObject(baseURL + "/update/" + "123", Printer.class);

        assertNotNull(updatedPrinter);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Printer printer = restTemplate.getForObject(baseURL + "/find/" + "123", Printer.class);
        assertNotNull(printer);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            printer = restTemplate.getForObject(baseURL + "/find/" + "123", Printer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);

        assertNotNull(response);

    }
}