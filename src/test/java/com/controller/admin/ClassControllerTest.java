package com.controller.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Class;
import com.factory.admin.ClassFactory;
import org.junit.Assert;
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
public class ClassControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/cls";

    @Test
    public void a_create() {

        Class cls = ClassFactory.getClass("97", "A");
        cls.setClassID("123");

        ResponseEntity<Class> postResponse = restTemplate.postForEntity(baseURL + "/new", cls, Class.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Class cls = restTemplate.getForObject(baseURL + "/find/" + "123", Class.class);

        assertNotNull(cls);
    }

    @Test
    public void c_update() {

        int id = 1;
        Class cls = restTemplate.getForObject(baseURL + "/find/" + "123", Class.class);
        cls.setClassGroup("7");

        restTemplate.put(baseURL + "/update/" + "123", cls);

        Class updatedClass = restTemplate.getForObject(baseURL + "/update/" + "123", Class.class);

        assertNotNull(updatedClass);
    }


    @Test
    public void e_delete() {

        int id = 1;
        Class cls = restTemplate.getForObject(baseURL + "/find/" + "123", Class.class);
        assertNotNull(cls);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            cls = restTemplate.getForObject(baseURL + "/find/" + "123", Class.class);
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