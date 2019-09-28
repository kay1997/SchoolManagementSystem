package com.controller.admin;


import app.SchoolManagementSystemApplication;
import com.domain.admin.Grade;
import com.factory.admin.GradeFactory;
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
public class GradeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/grade";

    @Test
    public void a_create() {

        Grade grade = GradeFactory.getGrade("7", "Foundation");
        grade.setGradeID("6");

        ResponseEntity<Grade> postResponse = restTemplate.postForEntity(baseURL + "/new", grade, Grade.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Grade grade = restTemplate.getForObject(baseURL + "/find/" + "6", Grade.class);

        assertNotNull(grade);
    }

    @Test
    public void c_update() {

        int id = 1;
        Grade grade = restTemplate.getForObject(baseURL + "/find/" + "6", Grade.class);
        grade.setGradeType("Senior");

        restTemplate.put(baseURL + "/update/" + "6", grade);

        Grade updatedGrade = restTemplate.getForObject(baseURL + "/update/" + "6", Grade.class);

        assertNotNull(updatedGrade);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Grade grade = restTemplate.getForObject(baseURL + "/find/" + "6", Grade.class);
        assertNotNull(grade);

        restTemplate.delete(baseURL + "/delete/" + "6");

        try {
            grade = restTemplate.getForObject(baseURL + "/find/" + "6", Grade.class);
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