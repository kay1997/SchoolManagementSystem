package com.controller.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Desk;
import com.factory.equipment.DeskFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class DeskControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/desk";

    @Test
    public void a_create() {

        Desk desk = DeskFactory.getDesk("97", "Plastic");
        desk.setDeskNumber("123");

        ResponseEntity<Desk> postResponse = restTemplate.postForEntity(baseURL + "/new", desk, Desk.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Desk desk = restTemplate.getForObject(baseURL + "/find/" + "123", Desk.class);

        assertNotNull(desk);
    }

    @Test
    public void c_update() {

        int id = 1;
        Desk desk = restTemplate.getForObject(baseURL + "/find/" + "123", Desk.class);
        desk.setDeskType("Wooden");

        restTemplate.put(baseURL + "/update/" + "123", desk);

        Desk updatedDesk = restTemplate.getForObject(baseURL + "/update/" + "123", Desk.class);

        assertNotNull(updatedDesk);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Desk desk = restTemplate.getForObject(baseURL + "/find/" + "123", Desk.class);
        assertNotNull(desk);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            desk = restTemplate.getForObject(baseURL + "/find/" + "123", Desk.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
}