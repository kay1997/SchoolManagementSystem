package com.controller.equipment;

import com.domain.equipment.Computer;
import com.factory.equipment.ComputerFactory;
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
public class ComputerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/computer";

    @Test
    public void testGetAllComputers() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetComputerByNo() {
        Computer computer = restTemplate.getForObject(baseURL + "/computer/1", Computer.class);
        System.out.println(computer.getComputerNumber());
        assertNotNull(computer);
    }

    @Ignore
    public void testCreateComputer() {
        Computer computer = ComputerFactory.getComputer("0854","Dell");
        ResponseEntity<Computer> postResponse = restTemplate.postForEntity(baseURL + "/create", computer, Computer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateComputer() {
        int id = 1;
        Computer computer = restTemplate.getForObject(baseURL + "/computer/" + id, Computer.class);

        restTemplate.put(baseURL + "/computers/" + id, computer);
        Computer updatedComputer = restTemplate.getForObject(baseURL + "/Computer/" + id, Computer.class);
        assertNotNull(updatedComputer);
    }

    @Ignore
    public void testDeleteComputer() {
        int id = 2;
        Computer computer = restTemplate.getForObject(baseURL + "/computers/" + id, Computer.class);
        assertNotNull(computer);
        restTemplate.delete(baseURL + "/computers/" + id);
        try {
            computer = restTemplate.getForObject(baseURL + "/computers/" + id, Computer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}


