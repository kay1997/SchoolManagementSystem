package com.controller.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Secretary;
import com.factory.people.SecretaryFactory;
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

public class SecretaryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/secretary";

    @Test
    public void a_create() {

        Secretary secretary = SecretaryFactory.getSecretary( "97", "Kaylen", "Abrahams", "260897", "CPT",  "1234567890", 21);
        secretary.setSecretaryIDNumber("970826");

        ResponseEntity<Secretary> postResponse = restTemplate.postForEntity(baseURL + "/new", secretary, Secretary.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Secretary secretary = restTemplate.getForObject(baseURL + "/find/" + "970826", Secretary.class);

        assertNotNull(secretary);
    }

    @Test
    public void c_update() {

        int id = 1;
        Secretary secretary = restTemplate.getForObject(baseURL + "/find/" + "970826", Secretary.class);
        secretary.setSecretaryFirstName("Kevin");

        restTemplate.put(baseURL + "/update/" + "970826", secretary);

        Secretary updatedSecretary = restTemplate.getForObject(baseURL + "/update/" + "970826", Secretary.class);

        assertNotNull(updatedSecretary);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Secretary secretary = restTemplate.getForObject(baseURL + "/find/" + "970826", Secretary.class);
        assertNotNull(secretary);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            secretary = restTemplate.getForObject(baseURL + "/find/" + "970826", Secretary.class);
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