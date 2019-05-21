package com.controller.assessments;

import com.domain.assessments.Assignment;
import com.factory.assessments.AssignmentFactory;
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
public class AssignmentControllerTest {

        @Autowired
        private TestRestTemplate restTemplate;
        private String baseURL="http://localhost:8080/assignment";

        @Test
        public void testGetAllAssignments() {
            HttpHeaders headers = new HttpHeaders();

            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                    HttpMethod.GET, entity, String.class);
            assertNotNull(response.getBody());
        }

        @Ignore
        public void testGetAssignmentByNo() {
            Assignment assignment = restTemplate.getForObject(baseURL + "/assignment/1", Assignment.class);
            System.out.println(assignment.getAssignmentNumber());
            assertNotNull(assignment);
        }

        @Ignore
        public void testCreateAssignment() {
            Assignment assignment = AssignmentFactory.getAssignment("2","Written");

            ResponseEntity<Assignment> postResponse = restTemplate.postForEntity(baseURL + "/create", assignment, Assignment.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
        }

        @Ignore
        public void testUpdateAssignment() {
            int id = 1;
            Assignment assignment = restTemplate.getForObject(baseURL + "/assignment/" + id, Assignment.class);

            restTemplate.put(baseURL + "/assignments/" + id, assignment);
            Assignment updatedAssignment = restTemplate.getForObject(baseURL + "/Assignment/" + id, Assignment.class);
            assertNotNull(updatedAssignment);
        }

        @Ignore
        public void testDeleteAssignment() {
            int id = 2;
            Assignment assignment = restTemplate.getForObject(baseURL + "/assignments/" + id, Assignment.class);
            assertNotNull(assignment);
            restTemplate.delete(baseURL + "/assignments/" + id);
            try {
                assignment = restTemplate.getForObject(baseURL + "/assignments/" + id, Assignment.class);
            } catch (final HttpClientErrorException e) {
                assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
            }
        }
    }
