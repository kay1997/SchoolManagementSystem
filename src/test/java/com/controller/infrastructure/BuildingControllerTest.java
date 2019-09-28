package com.controller.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Building;
import com.factory.infrastructure.BuildingFactory;
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
public class BuildingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/building";

    @Test
    public void a_create() {

        Building building = BuildingFactory.getBuilding("97", "Commerce");
        building.setBuildingNumber("123");

        ResponseEntity<Building> postResponse = restTemplate.postForEntity(baseURL + "/new", building, Building.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Building building = restTemplate.getForObject(baseURL + "/find/" + "123", Building.class);

        assertNotNull(building);
    }

    @Test
    public void c_update() {

        int id = 1;
        Building building = restTemplate.getForObject(baseURL + "/find/" + "123", Building.class);
        building.setBuildingName("Admin");

        restTemplate.put(baseURL + "/update/" + "123", building);

        Building updatedBuilding = restTemplate.getForObject(baseURL + "/update/" + "123", Building.class);

        assertNotNull(updatedBuilding);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Building building = restTemplate.getForObject(baseURL + "/find/" + "123", Building.class);
        assertNotNull(building);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            building = restTemplate.getForObject(baseURL + "/find/" + "123", Building.class);
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