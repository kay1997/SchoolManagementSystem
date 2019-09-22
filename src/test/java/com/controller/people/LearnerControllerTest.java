package com.controller.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Learner;
import com.factory.people.LearnerFactory;
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
public class LearnerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/learner";

    @Test
    public void a_create() {

        Learner learner = LearnerFactory.getLearner( "97", "Kaylen", "Abrahams", "260897", "CPT",  21);
        learner.setLearnerId("970826");

        ResponseEntity<Learner> postResponse = restTemplate.postForEntity(baseURL + "/new", learner, Learner.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Learner learner = restTemplate.getForObject(baseURL + "/find/" + "970826", Learner.class);

        assertNotNull(learner);
    }

    @Test
    public void c_update() {

        int id = 1;
        Learner learner = restTemplate.getForObject(baseURL + "/find/" + "970826", Learner.class);
        learner.setLearnerFirstName("Kevin");

        restTemplate.put(baseURL + "/update/" + "970826", learner);

        Learner updatedLearner = restTemplate.getForObject(baseURL + "/update/" + "970826", Learner.class);

        assertNotNull(updatedLearner);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Learner learner = restTemplate.getForObject(baseURL + "/find/" + "970826", Learner.class);
        assertNotNull(learner);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            learner = restTemplate.getForObject(baseURL + "/find/" + "970826", Learner.class);
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