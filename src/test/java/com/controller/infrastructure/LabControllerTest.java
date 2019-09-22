package com.controller.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Lab;
import com.factory.infrastructure.LabFactory;
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
public class LabControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/lab";

    @Test
    public void a_create() {

        Lab lab = LabFactory.getLab("97", "Computer");
        lab.setLabNumber("123");

        ResponseEntity<Lab> postResponse = restTemplate.postForEntity(baseURL + "/new", lab, Lab.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Lab lab = restTemplate.getForObject(baseURL + "/find/" + "123", Lab.class);

        assertNotNull(lab);
    }

    @Test
    public void c_update() {

        int id = 1;
        Lab lab = restTemplate.getForObject(baseURL + "/find/" + "123", Lab.class);
        lab.setLabType("Medical");

        restTemplate.put(baseURL + "/update/" + "123", lab);

        Lab updatedLab = restTemplate.getForObject(baseURL + "/update/" + "123", Lab.class);

        assertNotNull(updatedLab);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Lab lab = restTemplate.getForObject(baseURL + "/find/" + "123", Lab.class);
        assertNotNull(lab);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            lab = restTemplate.getForObject(baseURL + "/find/" + "123", Lab.class);
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