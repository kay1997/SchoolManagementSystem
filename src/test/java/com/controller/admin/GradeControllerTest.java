package com.controller.admin;


import com.domain.admin.Grade;
import com.factory.admin.GradeFactory;
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
public class GradeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/grade";

    @Test
    public void testGetAllGrades() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetGradeByNo() {
        Grade grade = restTemplate.getForObject(baseURL + "/grade/1", Grade.class);
        System.out.println(grade.getGradeNumber());
        assertNotNull(grade);
    }

    @Ignore
    public void testCreateGrade() {
        Grade grade = GradeFactory.getGrade("3");

        ResponseEntity<Grade> postResponse = restTemplate.postForEntity(baseURL + "/create", grade, Grade.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateGrade() {
        int id = 1;
        Grade grade = restTemplate.getForObject(baseURL + "/grade/" + id, Grade.class);

        restTemplate.put(baseURL + "/grades/" + id, grade);
        Grade updatedGrade = restTemplate.getForObject(baseURL + "/Grade/" + id, Grade.class);
        assertNotNull(updatedGrade);
    }

    @Ignore
    public void testDeleteGrade() {
        int id = 2;
        Grade grade = restTemplate.getForObject(baseURL + "/grades/" + id, Grade.class);
        assertNotNull(grade);
        restTemplate.delete(baseURL + "/grades/" + id);
        try {
            grade = restTemplate.getForObject(baseURL + "/grades/" + id, Grade.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

