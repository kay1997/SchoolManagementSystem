package com.controller.people;

import com.domain.people.Learner;
import com.factory.people.LearnerFactory;
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
public class LearnerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/learner";

    @Test
    public void testGetAllLearners() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetLearnerById() {
        Learner learner = restTemplate.getForObject(baseURL + "/learner/1", Learner.class);
        System.out.println(learner.getLearnerFirstName());
        assertNotNull(learner);
    }

    @Ignore
    public void testCreateLearner() {
        Learner learner = LearnerFactory.getLearner("800101"," Kay","Adams","010180", "Cape Town", 21);

        ResponseEntity<Learner> postResponse = restTemplate.postForEntity(baseURL + "/create", learner, Learner.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateLearner() {
        int id = 1;
        Learner learner = restTemplate.getForObject(baseURL + "/learner/" + id, Learner.class);

        restTemplate.put(baseURL + "/learners/" + id, learner);
        Learner updatedLearner = restTemplate.getForObject(baseURL + "/Learner/" + id, Learner.class);
        assertNotNull(updatedLearner);
    }

    @Ignore
    public void testDeleteLearner() {
        int id = 2;
        Learner learner = restTemplate.getForObject(baseURL + "/learners/" + id, Learner.class);
        assertNotNull(learner);
        restTemplate.delete(baseURL + "/learners/" + id);
        try {
            learner = restTemplate.getForObject(baseURL + "/learners/" + id, Learner.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

