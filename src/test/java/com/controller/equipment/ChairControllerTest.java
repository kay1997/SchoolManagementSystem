package com.controller.equipment;

import com.domain.equipment.Chair;
import com.factory.equipment.ChairFactory;
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
public class ChairControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/chair";

    @Test
    public void testGetAllChairs() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetChairByNo() {
        Chair chair = restTemplate.getForObject(baseURL + "/chair/1", Chair.class);
        System.out.println(chair.getChairNumber());
        assertNotNull(chair);
    }

    @Ignore
    public void testCreateChair() {
        Chair chair = ChairFactory.getChair("29");

        ResponseEntity<Chair> postResponse = restTemplate.postForEntity(baseURL + "/create", chair, Chair.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateChair() {
        int id = 1;
        Chair chair = restTemplate.getForObject(baseURL + "/chair/" + id, Chair.class);

        restTemplate.put(baseURL + "/chairs/" + id, chair);
        Chair updatedChair = restTemplate.getForObject(baseURL + "/Chair/" + id, Chair.class);
        assertNotNull(updatedChair);
    }

    @Ignore
    public void testDeleteChair() {
        int id = 2;
        Chair chair = restTemplate.getForObject(baseURL + "/chairs/" + id, Chair.class);
        assertNotNull(chair);
        restTemplate.delete(baseURL + "/chairs/" + id);
        try {
            chair = restTemplate.getForObject(baseURL + "/chairs/" + id, Chair.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

