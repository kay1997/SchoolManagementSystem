package com.controller.people;

import com.domain.people.Secretary;
import com.factory.people.SecretaryFactory;
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
public class SecretaryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/secretary";

    @Test
    public void testGetAllSecretarys() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSecretaryById() {
        Secretary secretary = restTemplate.getForObject(baseURL + "/secretary/1", Secretary.class);
        System.out.println(secretary.getSecretaryFirstName());
        assertNotNull(secretary);
    }

    @Ignore
    public void testCreateSecretary() {
        Secretary secretary = SecretaryFactory.getSecretary("800101"," Kay","Adams","010180", "Cape Town", "1234567890",29);

        ResponseEntity<Secretary> postResponse = restTemplate.postForEntity(baseURL + "/create", secretary, Secretary.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSecretary() {
        int id = 1;
        Secretary secretary = restTemplate.getForObject(baseURL + "/secretary/" + id, Secretary.class);

        restTemplate.put(baseURL + "/secretarys/" + id, secretary);
        Secretary updatedSecretary = restTemplate.getForObject(baseURL + "/Secretary/" + id, Secretary.class);
        assertNotNull(updatedSecretary);
    }

    @Ignore
    public void testDeleteSecretary() {
        int id = 2;
        Secretary secretary = restTemplate.getForObject(baseURL + "/secretarys/" + id, Secretary.class);
        assertNotNull(secretary);
        restTemplate.delete(baseURL + "/secretarys/" + id);
        try {
            secretary = restTemplate.getForObject(baseURL + "/secretarys/" + id, Secretary.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

