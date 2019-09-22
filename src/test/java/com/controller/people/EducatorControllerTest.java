package com.controller.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Educator;
import com.factory.people.EducatorFactory;
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
@ContextConfiguration(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EducatorControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/educator";

    @Test
    public void a_create() {

        Educator educator = EducatorFactory.getEducator( "97", "Kaylen", "Abrahams", "260897", "CPT", "1234567890", 21);
        educator.setEducatorIDNumber("970826");

        ResponseEntity<Educator> postResponse = restTemplate.postForEntity(baseURL + "/new", educator, Educator.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Educator educator = restTemplate.getForObject(baseURL + "/find/" + "970826", Educator.class);

        assertNotNull(educator);
    }

    @Test
    public void c_update() {

        int id = 1;
        Educator educator = restTemplate.getForObject(baseURL + "/find/" + "970826", Educator.class);
        educator.setEducatorFirstName("Kevin");

        restTemplate.put(baseURL + "/update/" + "970826", educator);

        Educator updatedEducator = restTemplate.getForObject(baseURL + "/update/" + "970826", Educator.class);

        assertNotNull(updatedEducator);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Educator educator = restTemplate.getForObject(baseURL + "/find/" + "970826", Educator.class);
        assertNotNull(educator);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            educator = restTemplate.getForObject(baseURL + "/find/" + "970826", Educator.class);
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

