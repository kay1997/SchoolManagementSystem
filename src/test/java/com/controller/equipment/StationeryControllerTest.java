package com.controller.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Stationery;
import com.factory.equipment.StationeryFactory;
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
public class StationeryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/stationery";

    @Test
    public void a_create() {

        Stationery stationery = StationeryFactory.getStationery("97", "Pen");
        stationery.setStationeryCode("123");

        ResponseEntity<Stationery> postResponse = restTemplate.postForEntity(baseURL + "/new", stationery, Stationery.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Stationery stationery = restTemplate.getForObject(baseURL + "/find/" + "123", Stationery.class);

        assertNotNull(stationery);
    }

    @Test
    public void c_update() {

        int id = 1;
        Stationery stationery = restTemplate.getForObject(baseURL + "/find/" + "123", Stationery.class);
        stationery.setStationeryType("Pencil");

        restTemplate.put(baseURL + "/update/" + "123", stationery);

        Stationery updatedStationery = restTemplate.getForObject(baseURL + "/update/" + "123", Stationery.class);

        assertNotNull(updatedStationery);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Stationery stationery = restTemplate.getForObject(baseURL + "/find/" + "123", Stationery.class);
        assertNotNull(stationery);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            stationery = restTemplate.getForObject(baseURL + "/find/" + "123", Stationery.class);
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