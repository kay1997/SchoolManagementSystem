package com.controller.infrastructure;

import com.domain.infrastructure.Lab;
import com.factory.infrastructure.LabFactory;
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
public class LabControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/lab";

    @Test
    public void testGetAllLabs() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetLabByNo() {
        Lab lab = restTemplate.getForObject(baseURL + "/lab/1", Lab.class);
        System.out.println(lab.getLabNumber());
        assertNotNull(lab);
    }

    @Ignore
    public void testCreateLab() {
        Lab lab = LabFactory.getLab("3","Computer");

        ResponseEntity<Lab> postResponse = restTemplate.postForEntity(baseURL + "/create", lab, Lab.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateLab() {
        int id = 1;
        Lab lab = restTemplate.getForObject(baseURL + "/lab/" + id, Lab.class);

        restTemplate.put(baseURL + "/labs/" + id, lab);
        Lab updatedLab = restTemplate.getForObject(baseURL + "/Lab/" + id, Lab.class);
        assertNotNull(updatedLab);
    }

    @Ignore
    public void testDeleteLab() {
        int id = 2;
        Lab lab = restTemplate.getForObject(baseURL + "/labs/" + id, Lab.class);
        assertNotNull(lab);
        restTemplate.delete(baseURL + "/labs/" + id);
        try {
            lab = restTemplate.getForObject(baseURL + "/labs/" + id, Lab.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

