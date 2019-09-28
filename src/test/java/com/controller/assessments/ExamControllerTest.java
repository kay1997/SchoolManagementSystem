package com.controller.assessments;

import app.SchoolManagementSystemApplication;
import com.domain.assessments.Exam;
import com.factory.assessments.ExamFactory;
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
public class ExamControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/exam";

    @Test
    public void a_create() {

        Exam exam = ExamFactory.getExam("97", "Written");
        exam.setExamPaperNumber("123");

        ResponseEntity<Exam> postResponse = restTemplate.postForEntity(baseURL + "/new", exam, Exam.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Exam exam = restTemplate.getForObject(baseURL + "/find/" + "123", Exam.class);

        assertNotNull(exam);
    }

    @Test
    public void c_update() {

        int id = 1;
        Exam exam = restTemplate.getForObject(baseURL + "/find/" + "123", Exam.class);
        exam.setExamType("Online");

        restTemplate.put(baseURL + "/update/" + "123", exam);

        Exam updatedExam = restTemplate.getForObject(baseURL + "/update/" + "123", Exam.class);

        assertNotNull(updatedExam);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Exam exam = restTemplate.getForObject(baseURL + "/find/" + "123", Exam.class);
        assertNotNull(exam);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            exam = restTemplate.getForObject(baseURL + "/find/" + "123", Exam.class);
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