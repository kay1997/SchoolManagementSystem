package com.controller.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Principle;
import com.factory.people.PrincipleFactory;
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
public class PrincipleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/principle";

    @Test
    public void a_create() {

        Principle principle = PrincipleFactory.getPrinciple( "97", "Kaylen", "Abrahams", "260897", "CPT",  "1234567890", 21);
        principle.setPrincipleIDNumber("970826");

        ResponseEntity<Principle> postResponse = restTemplate.postForEntity(baseURL + "/new", principle, Principle.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Principle principle = restTemplate.getForObject(baseURL + "/find/" + "970826", Principle.class);

        assertNotNull(principle);
    }

    @Test
    public void c_update() {

        int id = 1;
        Principle principle = restTemplate.getForObject(baseURL + "/find/" + "970826", Principle.class);
        principle.setPrincipleFirstName("Kevin");

        restTemplate.put(baseURL + "/update/" + "970826", principle);

        Principle updatedPrinciple = restTemplate.getForObject(baseURL + "/update/" + "970826", Principle.class);

        assertNotNull(updatedPrinciple);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Principle principle = restTemplate.getForObject(baseURL + "/find/" + "970826", Principle.class);
        assertNotNull(principle);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            principle = restTemplate.getForObject(baseURL + "/find/" + "970826", Principle.class);
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