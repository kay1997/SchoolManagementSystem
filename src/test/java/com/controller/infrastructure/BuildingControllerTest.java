package com.controller.infrastructure;

import com.domain.infrastructure.Building;
import com.factory.infrastructure.BuildingFactory;
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
public class BuildingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/building";

    @Test
    public void testGetAllBuildings() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetBuildingByNo() {
        Building building = restTemplate.getForObject(baseURL + "/building/1", Building.class);
        System.out.println(building.getBuildingNumber());
        assertNotNull(building);
    }

    @Ignore
    public void testCreateBuilding() {
        Building building = BuildingFactory.getBuilding("3","Admin");

        ResponseEntity<Building> postResponse = restTemplate.postForEntity(baseURL + "/create", building, Building.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateBuilding() {
        int id = 1;
        Building building = restTemplate.getForObject(baseURL + "/building/" + id, Building.class);

        restTemplate.put(baseURL + "/buildings/" + id, building);
        Building updatedBuilding = restTemplate.getForObject(baseURL + "/Building/" + id, Building.class);
        assertNotNull(updatedBuilding);
    }

    @Ignore
    public void testDeleteBuilding() {
        int id = 2;
        Building building = restTemplate.getForObject(baseURL + "/buildings/" + id, Building.class);
        assertNotNull(building);
        restTemplate.delete(baseURL + "/buildings/" + id);
        try {
            building = restTemplate.getForObject(baseURL + "/buildings/" + id, Building.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

