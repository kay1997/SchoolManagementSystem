package com.controller.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Room;
import com.factory.infrastructure.RoomFactory;
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
public class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL="http://localhost:8080/room";

    @Test
    public void a_create() {

        Room room = RoomFactory.getRoom( "97", "Meeting");
        room.setRoomNumber("123");

        ResponseEntity<Room> postResponse = restTemplate.postForEntity(baseURL + "/new", room, Room.class);

        assertNotNull(postResponse);
    }

    @Test
    public void b_findById() {

        Room room = restTemplate.getForObject(baseURL + "/find/" + "123", Room.class);

        assertNotNull(room);
    }

    @Test
    public void c_update() {

        int id = 1;
        Room room = restTemplate.getForObject(baseURL + "/find/" + "123", Room.class);
        room.setRoomType("Meeting");

        restTemplate.put(baseURL + "/update/" + "123", room);

        Room updatedRoom = restTemplate.getForObject(baseURL + "/update/" + "123", Room.class);

        assertNotNull(updatedRoom);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Room room = restTemplate.getForObject(baseURL + "/find/" + "123", Room.class);
        assertNotNull(room);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            room = restTemplate.getForObject(baseURL + "/find/" + "123", Room.class);
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