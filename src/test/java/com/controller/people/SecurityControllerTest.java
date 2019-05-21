package com.controller.people;

import com.domain.people.Security;
import com.factory.people.SecurityFactory;
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
public class SecurityControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/security";

    @Test
    public void testGetAllSecuritys() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSecurityById() {
        Security security = restTemplate.getForObject(baseURL + "/security/1", Security.class);
        System.out.println(security.getSecurityFirstName());
        assertNotNull(security);
    }

    @Ignore
    public void testCreateSecurity() {
        Security security = SecurityFactory.getSecurity("800101"," Kay","Adams","010180", "Cape Town", "1234567890",29);

        ResponseEntity<Security> postResponse = restTemplate.postForEntity(baseURL + "/create", security, Security.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSecurity() {
        int id = 1;
        Security security = restTemplate.getForObject(baseURL + "/security/" + id, Security.class);

        restTemplate.put(baseURL + "/securitys/" + id, security);
        Security updatedSecurity = restTemplate.getForObject(baseURL + "/Security/" + id, Security.class);
        assertNotNull(updatedSecurity);
    }

    @Ignore
    public void testDeleteSecurity() {
        int id = 2;
        Security security = restTemplate.getForObject(baseURL + "/securitys/" + id, Security.class);
        assertNotNull(security);
        restTemplate.delete(baseURL + "/securitys/" + id);
        try {
            security = restTemplate.getForObject(baseURL + "/securitys/" + id, Security.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

