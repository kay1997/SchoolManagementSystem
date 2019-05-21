package com.controller.equipment;

import com.domain.equipment.Stationery;
import com.factory.equipment.StationeryFactory;
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
public class StationeryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/stationery";

    @Test
    public void testGetAllStationerys() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetStationeryByCode() {
        Stationery stationery = restTemplate.getForObject(baseURL + "/stationery/1", Stationery.class);
        System.out.println(stationery.getStationeryCode());
        assertNotNull(stationery);
    }

    @Ignore
    public void testCreateStationery() {
        Stationery stationery = StationeryFactory.getStationery("Pen001","Pen");

        ResponseEntity<Stationery> postResponse = restTemplate.postForEntity(baseURL + "/create", stationery, Stationery.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateStationery() {
        int id = 1;
        Stationery stationery = restTemplate.getForObject(baseURL + "/stationery/" + id, Stationery.class);

        restTemplate.put(baseURL + "/educators/" + id, stationery);
        Stationery updatedStationery = restTemplate.getForObject(baseURL + "/Stationery/" + id, Stationery.class);
        assertNotNull(updatedStationery);
    }

    @Ignore
    public void testDeleteStationery() {
        int id = 2;
        Stationery stationery = restTemplate.getForObject(baseURL + "/educators/" + id, Stationery.class);
        assertNotNull(stationery);
        restTemplate.delete(baseURL + "/educators/" + id);
        try {
            stationery = restTemplate.getForObject(baseURL + "/educators/" + id, Stationery.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

