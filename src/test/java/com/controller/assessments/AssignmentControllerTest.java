package com.controller.assessments;

import app.SchoolManagementSystemApplication;
import com.domain.assessments.Assignment;
import com.factory.assessments.AssignmentFactory;
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
public class AssignmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/assignment";

    @Test
    public void a_create() {

        Assignment assignment = AssignmentFactory.getAssignment("97", "Written");
        assignment.setAssignmentNumber("123");

        ResponseEntity<Assignment> postResponse = restTemplate.postForEntity(baseURL + "/new", assignment, Assignment.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Assignment assignment = restTemplate.getForObject(baseURL + "/find/" + "123", Assignment.class);

        assertNotNull(assignment);
    }

    @Test
    public void c_update() {

        int id = 1;
        Assignment assignment = restTemplate.getForObject(baseURL + "/find/" + "123", Assignment.class);
        assignment.setAssignmentType("Practical");

        restTemplate.put(baseURL + "/update/" + "123", assignment);

        Assignment updatedAssignment = restTemplate.getForObject(baseURL + "/update/" + "123", Assignment.class);

        assertNotNull(updatedAssignment);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Assignment assignment = restTemplate.getForObject(baseURL + "/find/" + "123", Assignment.class);
        assertNotNull(assignment);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            assignment = restTemplate.getForObject(baseURL + "/find/" + "123", Assignment.class);
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