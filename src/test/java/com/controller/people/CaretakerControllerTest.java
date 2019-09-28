package com.controller.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Caretaker;
import com.factory.people.CaretakerFactory;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SchoolManagementSystemApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CaretakerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/caretaker";

    @Test
    public void a_create() {

        Caretaker caretaker = CaretakerFactory.getCaretaker( "97", "Kaylen", "Abrahams", "260897", "CPT", "1234567890", 21);
        caretaker.setCaretakerIDNumber("970826");

        ResponseEntity<Caretaker> postResponse = restTemplate.postForEntity(baseURL + "/new", caretaker, Caretaker.class);

        assertNotNull(postResponse);

    }

    @Test
    public void b_findById() {

        Caretaker caretaker = restTemplate.getForObject(baseURL + "/find/" + "970826", Caretaker.class);

        assertNotNull(caretaker);
    }

    @Test
    public void c_update() {

        int id = 1;
        Caretaker caretaker = restTemplate.getForObject(baseURL + "/find/" + "970826", Caretaker.class);
        caretaker.setCaretakerFirstName("Kevin");

        restTemplate.put(baseURL + "/update/" + "970826", caretaker);

        Caretaker updatedCaretaker = restTemplate.getForObject(baseURL + "/update/" + "970826", Caretaker.class);

        assertNotNull(updatedCaretaker);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Caretaker caretaker = restTemplate.getForObject(baseURL + "/find/" + "970826", Caretaker.class);
        assertNotNull(caretaker);

        restTemplate.delete(baseURL + "/delete/" + "970826");

        try {
            caretaker = restTemplate.getForObject(baseURL + "/find/" + "970826", Caretaker.class);
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


