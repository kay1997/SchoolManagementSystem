package com.controller.equipment;

import com.domain.equipment.Projector;
import com.factory.equipment.ProjectorFactory;
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
public class ProjectorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/projector";

    @Test
    public void testGetAllProjectors() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetProjectorByCode() {
        Projector projector = restTemplate.getForObject(baseURL + "/projector/1", Projector.class);
        System.out.println(projector.getProjectorCode());
        assertNotNull(projector);
    }

    @Ignore
    public void testCreateProjector() {
        Projector projector = ProjectorFactory.getProjector("801","Samsung");

        ResponseEntity<Projector> postResponse = restTemplate.postForEntity(baseURL + "/create", projector, Projector.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateProjector() {
        int id = 1;
        Projector projector = restTemplate.getForObject(baseURL + "/projector/" + id, Projector.class);

        restTemplate.put(baseURL + "/projectors/" + id, projector);
        Projector updatedProjector = restTemplate.getForObject(baseURL + "/Projector/" + id, Projector.class);
        assertNotNull(updatedProjector);
    }

    @Ignore
    public void testDeleteProjector() {
        int id = 2;
        Projector projector = restTemplate.getForObject(baseURL + "/projectors/" + id, Projector.class);
        assertNotNull(projector);
        restTemplate.delete(baseURL + "/projectors/" + id);
        try {
            projector = restTemplate.getForObject(baseURL + "/projectors/" + id, Projector.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

