package com.controller.admin;

import com.domain.admin.Class;
import com.factory.admin.ClassFactory;
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
public class ClassControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/oneClass";

    @Test
    public void testGetAllClasss() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetClassByGroup() {
        Class oneClass = restTemplate.getForObject(baseURL + "/oneClass/1", Class.class);
        System.out.println(oneClass.getClassGroup());
        assertNotNull(oneClass);
    }

    @Ignore
    public void testCreateClass() {
        Class oneClass = ClassFactory.getClass("A");

        ResponseEntity<Class> postResponse = restTemplate.postForEntity(baseURL + "/create", oneClass, Class.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateClass() {
        int id = 1;
        Class oneClass = restTemplate.getForObject(baseURL + "/oneClass/" + id, Class.class);

        restTemplate.put(baseURL + "/oneClasss/" + id, oneClass);
        Class updatedClass = restTemplate.getForObject(baseURL + "/Class/" + id, Class.class);
        assertNotNull(updatedClass);
    }

    @Ignore
    public void testDeleteClass() {
        int id = 2;
        Class oneClass = restTemplate.getForObject(baseURL + "/oneClasss/" + id, Class.class);
        assertNotNull(oneClass);
        restTemplate.delete(baseURL + "/oneClasss/" + id);
        try {
            oneClass = restTemplate.getForObject(baseURL + "/oneClasss/" + id, Class.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

