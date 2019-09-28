package com.controller.assessments;

import app.SchoolManagementSystemApplication;

import com.factory.assessments.TestFactory;
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
public class TestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/test";

    @org.junit.Test
    public void a_create() {

        com.domain.assessments.Test test = TestFactory.getTest("97", "Online");
        test.setTestPaperNumber("123");

        ResponseEntity<com.domain.assessments.Test> postResponse = restTemplate.postForEntity(baseURL + "/new", test, com.domain.assessments.Test.class);

        assertNotNull(postResponse);
    }

    @org.junit.Test
    public void b_findById() {

        com.domain.assessments.Test test = restTemplate.getForObject(baseURL + "/find/" + "123", com.domain.assessments.Test.class);

        assertNotNull(test);
    }

    @org.junit.Test
    public void c_update() {

        int id = 1;
        com.domain.assessments.Test test = restTemplate.getForObject(baseURL + "/find/" + "123", com.domain.assessments.Test.class);
        test.setTestType("Written");

        restTemplate.put(baseURL + "/update/" + "123", test);

        com.domain.assessments.Test updatedRoom = restTemplate.getForObject(baseURL + "/update/" + "123", com.domain.assessments.Test.class);

        assertNotNull(updatedRoom);

    }

    @org.junit.Test
    public void e_delete() {

        int id = 1;
        com.domain.assessments.Test test = restTemplate.getForObject(baseURL + "/find/" + "123", com.domain.assessments.Test.class);
        assertNotNull(test);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            test = restTemplate.getForObject(baseURL + "/find/" + "123", com.domain.assessments.Test.class);
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