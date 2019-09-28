package com.controller.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Subject;
import com.factory.admin.SubjectFactory;
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
public class SubjectControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/subject";

    @Test
    public void a_create() {

        Subject subject = SubjectFactory.getSubject("97", "Maths");
        subject.setSubjectCode("123");

        ResponseEntity<Subject> postResponse = restTemplate.postForEntity(baseURL + "/new", subject, Subject.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Subject subject = restTemplate.getForObject(baseURL + "/find/" + "123", Subject.class);

        assertNotNull(subject);
    }

    @Test
    public void c_update() {

        int id = 1;
        Subject subject = restTemplate.getForObject(baseURL + "/find/" + "123", Subject.class);
        subject.setSubjectName("Afrikaans");

        restTemplate.put(baseURL + "/update/" + "123", subject);

        Subject updatedSubject = restTemplate.getForObject(baseURL + "/update/" + "123", Subject.class);

        assertNotNull(updatedSubject);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Subject subject = restTemplate.getForObject(baseURL + "/find/" + "123", Subject.class);
        assertNotNull(subject);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            subject = restTemplate.getForObject(baseURL + "/find/" + "123", Subject.class);
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