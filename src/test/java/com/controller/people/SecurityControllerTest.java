package com.controller.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Security;
import com.factory.people.SecurityFactory;
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
public class SecurityControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/security";

    @Test
    public void a_create() {

        Security security = SecurityFactory.getSecurity( "97", "Kaylen", "Abrahams", "260897", "CPT",  "1234567890", 21);
        security.setSecurityIDNumber("970826");

        ResponseEntity<Security> postResponse = restTemplate.postForEntity(baseURL + "/new", security, Security.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Security security = restTemplate.getForObject(baseURL + "/find/" + "970826", Security.class);

        assertNotNull(security);
    }

    @Test
    public void c_update() {

        int id = 1;
        Security security = restTemplate.getForObject(baseURL + "/find/" + "970826", Security.class);
        security.setSecurityFirstName("Kevin");

        restTemplate.put(baseURL + "/update/" + "970826", security);

        Security updatedSecurity = restTemplate.getForObject(baseURL + "/update/" + "970826", Security.class);

        assertNotNull(updatedSecurity);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Security security = restTemplate.getForObject(baseURL + "/find/" + "970826", Security.class);
        assertNotNull(security);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            security = restTemplate.getForObject(baseURL + "/find/" + "970826", Security.class);
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