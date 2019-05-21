package com.controller.infrastructure;

import com.domain.infrastructure.Room;
import com.factory.infrastructure.RoomFactory;
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
public class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/room";

    @Test
    public void testGetAllRooms() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetRoomByNo() {
        Room room = restTemplate.getForObject(baseURL + "/room/1", Room.class);
        System.out.println(room.getRoomNumber());
        assertNotNull(room);
    }

    @Ignore
    public void testCreateRoom() {
        Room room = RoomFactory.getRoom("3");

        ResponseEntity<Room> postResponse = restTemplate.postForEntity(baseURL + "/create", room, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateRoom() {
        int id = 1;
        Room room = restTemplate.getForObject(baseURL + "/room/" + id, Room.class);

        restTemplate.put(baseURL + "/rooms/" + id, room);
        Room updatedRoom = restTemplate.getForObject(baseURL + "/Room/" + id, Room.class);
        assertNotNull(updatedRoom);
    }

    @Ignore
    public void testDeleteRoom() {
        int id = 2;
        Room room = restTemplate.getForObject(baseURL + "/rooms/" + id, Room.class);
        assertNotNull(room);
        restTemplate.delete(baseURL + "/rooms/" + id);
        try {
            room = restTemplate.getForObject(baseURL + "/rooms/" + id, Room.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

