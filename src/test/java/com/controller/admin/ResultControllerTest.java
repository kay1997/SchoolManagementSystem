package com.controller.admin;

import com.domain.admin.Result;
import com.factory.admin.ResultFactory;
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
public class ResultControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/result";

    @Test
    public void testGetAllResults() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetResultById() {
        Result result = restTemplate.getForObject(baseURL + "/result/1", Result.class);
        System.out.println(result.getSubjectMark());
        assertNotNull(result);
    }

    @Ignore
    public void testCreateResult() {
        Result result = ResultFactory.getResult("29");

        ResponseEntity<Result> postResponse = restTemplate.postForEntity(baseURL + "/create", result, Result.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateResult() {
        int id = 1;
        Result result = restTemplate.getForObject(baseURL + "/result/" + id, Result.class);

        restTemplate.put(baseURL + "/results/" + id, result);
        Result updatedResult = restTemplate.getForObject(baseURL + "/Result/" + id, Result.class);
        assertNotNull(updatedResult);
    }

    @Ignore
    public void testDeleteResult() {
        int id = 2;
        Result result = restTemplate.getForObject(baseURL + "/results/" + id, Result.class);
        assertNotNull(result);
        restTemplate.delete(baseURL + "/results/" + id);
        try {
            result = restTemplate.getForObject(baseURL + "/results/" + id, Result.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

