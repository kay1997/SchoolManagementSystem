package com.controller.people;

import com.domain.people.Caretaker;
import com.factory.people.CaretakerFactory;
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
public class CaretakerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/caretaker";

    @Test
    public void testGetAllCaretakers() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetCaretakerById() {
        Caretaker caretaker = restTemplate.getForObject(baseURL + "/caretaker/1", Caretaker.class);
        System.out.println(caretaker.getCaretakerFirstName());
        assertNotNull(caretaker);
    }

    @Ignore
    public void testCreateCaretaker() {
        Caretaker caretaker = CaretakerFactory.getCaretaker("800101"," Kay","Adams","010180", "Cape Town", "1234567890",29);

        ResponseEntity<Caretaker> postResponse = restTemplate.postForEntity(baseURL + "/create", caretaker, Caretaker.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateCaretaker() {
        int id = 1;
        Caretaker caretaker = restTemplate.getForObject(baseURL + "/caretaker/" + id, Caretaker.class);

        restTemplate.put(baseURL + "/caretakers/" + id, caretaker);
        Caretaker updatedCaretaker = restTemplate.getForObject(baseURL + "/Caretaker/" + id, Caretaker.class);
        assertNotNull(updatedCaretaker);
    }

    @Ignore
    public void testDeleteCaretaker() {
        int id = 2;
        Caretaker caretaker = restTemplate.getForObject(baseURL + "/caretakers/" + id, Caretaker.class);
        assertNotNull(caretaker);
        restTemplate.delete(baseURL + "/caretakers/" + id);
        try {
            caretaker = restTemplate.getForObject(baseURL + "/caretakers/" + id, Caretaker.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}


