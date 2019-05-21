package com.controller.assessments;

import com.domain.assessments.Exam;
import com.factory.assessments.ExamFactory;
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
public class ExamControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/exam";

    @Test
    public void testGetAllExams() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetExamByNo() {
        Exam exam = restTemplate.getForObject(baseURL + "/exam/1", Exam.class);
        System.out.println(exam.getExamPaperNumber());
        assertNotNull(exam);
    }

    @Ignore
    public void testCreateExam() {
        Exam exam = ExamFactory.getExam("1","Written");

        ResponseEntity<Exam> postResponse = restTemplate.postForEntity(baseURL + "/create", exam, Exam.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateExam() {
        int id = 1;
        Exam exam = restTemplate.getForObject(baseURL + "/exam/" + id, Exam.class);

        restTemplate.put(baseURL + "/exams/" + id, exam);
        Exam updatedExam = restTemplate.getForObject(baseURL + "/Exam/" + id, Exam.class);
        assertNotNull(updatedExam);
    }

    @Ignore
    public void testDeleteExam() {
        int id = 2;
        Exam exam = restTemplate.getForObject(baseURL + "/exams/" + id, Exam.class);
        assertNotNull(exam);
        restTemplate.delete(baseURL + "/exams/" + id);
        try {
            exam = restTemplate.getForObject(baseURL + "/exams/" + id, Exam.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

