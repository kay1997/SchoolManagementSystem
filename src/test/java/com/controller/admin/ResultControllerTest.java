package com.controller.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Result;
import com.factory.admin.ResultFactory;
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
public class ResultControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/result";

    @Test
    public void a_create() {

        Result result = ResultFactory.getResult("97", "70");
        result.setLearnerID("123");

        ResponseEntity<Result> postResponse = restTemplate.postForEntity(baseURL + "/new", result, Result.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Result result = restTemplate.getForObject(baseURL + "/find/" + "123", Result.class);

        assertNotNull(result);
    }

    @Test
    public void c_update() {

        int id = 1;
        Result result = restTemplate.getForObject(baseURL + "/find/" + "123", Result.class);
        result.setSubjectMark("90");

        restTemplate.put(baseURL + "/update/" + "123", result);

        Result updatedResult = restTemplate.getForObject(baseURL + "/update/" + "123", Result.class);

        assertNotNull(updatedResult);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Result result = restTemplate.getForObject(baseURL + "/find/" + "123", Result.class);
        assertNotNull(result);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            result = restTemplate.getForObject(baseURL + "/find/" + "123", Result.class);
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