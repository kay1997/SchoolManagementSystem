package com.controller.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Computer;
import com.factory.equipment.ComputerFactory;
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
public class ComputerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/computer";

    @Test
    public void a_create() {

        Computer computer = ComputerFactory.getComputer("97", "Mac");
        computer.setComputerNumber("123");

        ResponseEntity<Computer> postResponse = restTemplate.postForEntity(baseURL + "/new", computer, Computer.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Computer computer = restTemplate.getForObject(baseURL + "/find/" + "123", Computer.class);

        assertNotNull(computer);
    }

    @Test
    public void c_update() {

        int id = 1;
        Computer computer = restTemplate.getForObject(baseURL + "/find/" + "123", Computer.class);
        computer.setComputerName("Dell");

        restTemplate.put(baseURL + "/update/" + "123", computer);

        Computer updatedComputer = restTemplate.getForObject(baseURL + "/update/" + "123", Computer.class);

        assertNotNull(updatedComputer);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Computer computer = restTemplate.getForObject(baseURL + "/find/" + "123", Computer.class);
        assertNotNull(computer);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            computer = restTemplate.getForObject(baseURL + "/find/" + "123", Computer.class);
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