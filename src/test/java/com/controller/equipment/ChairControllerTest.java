package com.controller.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Chair;
import com.factory.equipment.ChairFactory;
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
public class ChairControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/chair";

    @Test
    public void a_create() {

        Chair chair = ChairFactory.getChair("97", "Steel");
        chair.setChairNumber("123");

        ResponseEntity<Chair> postResponse = restTemplate.postForEntity(baseURL + "/new", chair, Chair.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Chair chair = restTemplate.getForObject(baseURL + "/find/" + "123", Chair.class);

        assertNotNull(chair);
    }

    @Test
    public void c_update() {

        int id = 1;
        Chair chair = restTemplate.getForObject(baseURL + "/find/" + "123", Chair.class);
        chair.setChairType("Wooden");

        restTemplate.put(baseURL + "/update/" + "123", chair);

        Chair updatedChair = restTemplate.getForObject(baseURL + "/update/" + "123", Chair.class);

        assertNotNull(updatedChair);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Chair chair = restTemplate.getForObject(baseURL + "/find/" + "123", Chair.class);
        assertNotNull(chair);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            chair = restTemplate.getForObject(baseURL + "/find/" + "123", Chair.class);
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