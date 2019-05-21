package com.controller.equipment;

import com.domain.equipment.Desk;
import com.factory.equipment.DeskFactory;
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
public class DeskControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/desk";

    @Test
    public void testGetAllDesks() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetDeskByNo() {
        Desk desk = restTemplate.getForObject(baseURL + "/desk/1", Desk.class);
        System.out.println(desk.getDeskNumber());
        assertNotNull(desk);
    }

    @Ignore
    public void testCreateDesk() {
        Desk desk = DeskFactory.getDesk("9");

        ResponseEntity<Desk> postResponse = restTemplate.postForEntity(baseURL + "/create", desk, Desk.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateDesk() {
        int id = 1;
        Desk desk = restTemplate.getForObject(baseURL + "/desk/" + id, Desk.class);

        restTemplate.put(baseURL + "/educators/" + id, desk);
        Desk updatedDesk = restTemplate.getForObject(baseURL + "/Desk/" + id, Desk.class);
        assertNotNull(updatedDesk);
    }

    @Ignore
    public void testDeleteDesk() {
        int id = 2;
        Desk desk = restTemplate.getForObject(baseURL + "/educators/" + id, Desk.class);
        assertNotNull(desk);
        restTemplate.delete(baseURL + "/educators/" + id);
        try {
            desk = restTemplate.getForObject(baseURL + "/educators/" + id, Desk.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}


