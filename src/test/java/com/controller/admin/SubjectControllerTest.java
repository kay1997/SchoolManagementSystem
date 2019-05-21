package com.controller.admin;

import com.domain.admin.Subject;
import com.factory.admin.SubjectFactory;
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
public class SubjectControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/subject";

    @Test
    public void testGetAllSubjects() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSubjectByCode() {
        Subject subject = restTemplate.getForObject(baseURL + "/subject/1", Subject.class);
        System.out.println(subject.getSubjectCode());
        assertNotNull(subject);
    }

    @Ignore
    public void testCreateSubject() {
        Subject subject = SubjectFactory.getSubject("Acc1","Accounting");

        ResponseEntity<Subject> postResponse = restTemplate.postForEntity(baseURL + "/create", subject, Subject.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSubject() {
        int id = 1;
        Subject subject = restTemplate.getForObject(baseURL + "/subject/" + id, Subject.class);

        restTemplate.put(baseURL + "/subjects/" + id, subject);
        Subject updatedSubject = restTemplate.getForObject(baseURL + "/Subject/" + id, Subject.class);
        assertNotNull(updatedSubject);
    }

    @Ignore
    public void testDeleteSubject() {
        int id = 2;
        Subject subject = restTemplate.getForObject(baseURL + "/subjects/" + id, Subject.class);
        assertNotNull(subject);
        restTemplate.delete(baseURL + "/subjects/" + id);
        try {
            subject = restTemplate.getForObject(baseURL + "/subjects/" + id, Subject.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

