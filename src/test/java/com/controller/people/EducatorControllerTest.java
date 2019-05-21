package com.controller.people;

import com.domain.people.Educator;
import com.factory.people.EducatorFactory;
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
public class EducatorControllerTest {

        @Autowired
        private TestRestTemplate restTemplate;
        private String baseURL="http://localhost:8080/educator";

        @Test
        public void testGetAllEducators() {
            HttpHeaders headers = new HttpHeaders();

            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                    HttpMethod.GET, entity, String.class);
            assertNotNull(response.getBody());
        }

        @Ignore
        public void testGetEducatorById() {
            Educator educator = restTemplate.getForObject(baseURL + "/educator/1", Educator.class);
            System.out.println(educator.getEducatorFirstName());
            assertNotNull(educator);
        }

        @Ignore
        public void testCreateEducator() {
            Educator educator = EducatorFactory.getEducator("800101"," Kay","Adams","010180", "Cape Town", "1234567890",29);

            ResponseEntity<Educator> postResponse = restTemplate.postForEntity(baseURL + "/create", educator, Educator.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
        }

        @Ignore
        public void testUpdateEducator() {
            int id = 1;
            Educator educator = restTemplate.getForObject(baseURL + "/educator/" + id, Educator.class);

            restTemplate.put(baseURL + "/educators/" + id, educator);
            Educator updatedEducator = restTemplate.getForObject(baseURL + "/Educator/" + id, Educator.class);
            assertNotNull(updatedEducator);
        }

        @Ignore
        public void testDeleteEducator() {
            int id = 2;
            Educator educator = restTemplate.getForObject(baseURL + "/educators/" + id, Educator.class);
            assertNotNull(educator);
            restTemplate.delete(baseURL + "/educators/" + id);
            try {
                educator = restTemplate.getForObject(baseURL + "/educators/" + id, Educator.class);
            } catch (final HttpClientErrorException e) {
                assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
            }
        }
    }

