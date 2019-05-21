package com.controller.people;

import com.domain.people.Principle;
import com.factory.people.PrincipleFactory;
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
public class PrincipleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/principle";

    @Test
    public void testGetAllPrinciples() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetPrincipleById() {
        Principle principle = restTemplate.getForObject(baseURL + "/principle/1", Principle.class);
        System.out.println(principle.getPrincipleFirstName());
        assertNotNull(principle);
    }

    @Ignore
    public void testCreatePrinciple() {
        Principle principle = PrincipleFactory.getPrinciple("800101"," Kay","Adams","010180", "Cape Town", "1234567890",29);

        ResponseEntity<Principle> postResponse = restTemplate.postForEntity(baseURL + "/create", principle, Principle.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdatePrinciple() {
        int id = 1;
        Principle principle = restTemplate.getForObject(baseURL + "/principle/" + id, Principle.class);

        restTemplate.put(baseURL + "/principles/" + id, principle);
        Principle updatedPrinciple = restTemplate.getForObject(baseURL + "/Principle/" + id, Principle.class);
        assertNotNull(updatedPrinciple);
    }

    @Ignore
    public void testDeletePrinciple() {
        int id = 2;
        Principle principle = restTemplate.getForObject(baseURL + "/principles/" + id, Principle.class);
        assertNotNull(principle);
        restTemplate.delete(baseURL + "/principles/" + id);
        try {
            principle = restTemplate.getForObject(baseURL + "/principles/" + id, Principle.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

