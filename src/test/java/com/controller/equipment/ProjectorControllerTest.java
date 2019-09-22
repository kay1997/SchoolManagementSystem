package com.controller.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Projector;
import com.factory.equipment.ProjectorFactory;
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
public class ProjectorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/projector";

    @Test
    public void a_create() {

        Projector projector = ProjectorFactory.getProjector("97", "Samsung");
        projector.setProjectorCode("123");

        ResponseEntity<Projector> postResponse = restTemplate.postForEntity(baseURL + "/new", projector, Projector.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Projector projector = restTemplate.getForObject(baseURL + "/find/" + "123", Projector.class);

        assertNotNull(projector);
    }

    @Test
    public void c_update() {

        int id = 1;
        Projector projector = restTemplate.getForObject(baseURL + "/find/" + "123", Projector.class);
        projector.setProjectorName("Canon");

        restTemplate.put(baseURL + "/update/" + "123", projector);

        Projector updatedProjector = restTemplate.getForObject(baseURL + "/update/" + "123", Projector.class);

        assertNotNull(updatedProjector);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Projector projector = restTemplate.getForObject(baseURL + "/find/" + "123", Projector.class);
        assertNotNull(projector);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            projector = restTemplate.getForObject(baseURL + "/find/" + "123", Projector.class);
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