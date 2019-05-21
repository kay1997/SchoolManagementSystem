package com.controller.assessments;

import com.domain.assessments.Test;

import com.factory.assessments.TestFactory;
import org.junit.Ignore;
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
public class TestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/test";

    @org.junit.Test
    public void testGetAllTests() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetTestByNo() {
        Test test = restTemplate.getForObject(baseURL + "/test/1", Test.class);
        System.out.println(test.getTestPaperNumber());
        assertNotNull(test);
    }

    @Ignore
    public void testCreateTest() {
        Test test = TestFactory.getTest("12","Written");

        ResponseEntity<Test> postResponse = restTemplate.postForEntity(baseURL + "/create", test, Test.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateTest() {
        int id = 1;
        Test test = restTemplate.getForObject(baseURL + "/test/" + id, Test.class);

        restTemplate.put(baseURL + "/educators/" + id, test);
        Test updatedTest = restTemplate.getForObject(baseURL + "/Test/" + id, Test.class);
        assertNotNull(updatedTest);
    }

    @Ignore
    public void testDeleteTest() {
        int id = 2;
        Test test = restTemplate.getForObject(baseURL + "/educators/" + id, Test.class);
        assertNotNull(test);
        restTemplate.delete(baseURL + "/educators/" + id);
        try {
            test = restTemplate.getForObject(baseURL + "/educators/" + id, Test.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

