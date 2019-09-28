package com.controller.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.School;
import com.factory.admin.SchoolFactory;
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

public class SchoolControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/school";

    @Test
    public void a_create() {

        School school = SchoolFactory.getSchool( "97", "Rocklands",  "CPT", "1234567890");
        school.setSchoolCode("970826");

        ResponseEntity<School> postResponse = restTemplate.postForEntity(baseURL + "/new", school, School.class);

        assertNotNull(postResponse);

    }

    @Test
    public void b_findById() {

        School school = restTemplate.getForObject(baseURL + "/find/" + "970826", School.class);

        assertNotNull(school);
    }

    @Test
    public void c_update() {

        int id = 1;
        School school = restTemplate.getForObject(baseURL + "/find/" + "970826", School.class);
        school.setSchoolName("Westridge");

        restTemplate.put(baseURL + "/update/" + "970826", school);

        School updatedSchool = restTemplate.getForObject(baseURL + "/update/" + "970826", School.class);

        assertNotNull(updatedSchool);

    }

    @Test
    public void e_delete() {

        int id = 1;
        School school = restTemplate.getForObject(baseURL + "/find/" + "970826", School.class);
        assertNotNull(school);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            school = restTemplate.getForObject(baseURL + "/find/" + "970826", School.class);
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


