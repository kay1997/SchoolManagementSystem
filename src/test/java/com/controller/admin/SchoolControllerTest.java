package com.controller.admin;

import com.domain.admin.School;
import com.factory.admin.SchoolFactory;
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
public class SchoolControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/school";

    @Test
    public void testGetAllSchools() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSchoolByCode() {
        School school = restTemplate.getForObject(baseURL + "/school/1", School.class);
        System.out.println(school.getSchoolCode());
        assertNotNull(school);
    }

    @Ignore
    public void testCreateSchool() {
        School school = SchoolFactory.getSchool("S001"," Seaview","Rocklands", "1234567890");

        ResponseEntity<School> postResponse = restTemplate.postForEntity(baseURL + "/create", school, School.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSchool() {
        int id = 1;
        School school = restTemplate.getForObject(baseURL + "/school/" + id, School.class);

        restTemplate.put(baseURL + "/educators/" + id, school);
        School updatedSchool = restTemplate.getForObject(baseURL + "/School/" + id, School.class);
        assertNotNull(updatedSchool);
    }

    @Ignore
    public void testDeleteSchool() {
        int id = 2;
        School school = restTemplate.getForObject(baseURL + "/educators/" + id, School.class);
        assertNotNull(school);
        restTemplate.delete(baseURL + "/educators/" + id);
        try {
            school = restTemplate.getForObject(baseURL + "/educators/" + id, School.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}


