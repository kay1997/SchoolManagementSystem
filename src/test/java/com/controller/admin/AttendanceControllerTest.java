package com.controller.admin;

import com.domain.admin.Attendance;
import com.factory.admin.AttendanceFactory;
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
public class AttendanceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/attendance";

    @Test
    public void testGetAllAttendances() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetAttendanceById() {
        Attendance attendance = restTemplate.getForObject(baseURL + "/attendance/1", Attendance.class);
        System.out.println(attendance.getNumberOfDaysPresent());
        assertNotNull(attendance);
    }

    @Ignore
    public void testCreateAttendance() {
        Attendance attendance = AttendanceFactory.getAttendance(2, "64");

        ResponseEntity<Attendance> postResponse = restTemplate.postForEntity(baseURL + "/create", attendance, Attendance.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateAttendance() {
        int id = 1;
        Attendance attendance = restTemplate.getForObject(baseURL + "/attendance/" + id, Attendance.class);

        restTemplate.put(baseURL + "/attendances/" + id, attendance);
        Attendance updatedAttendance = restTemplate.getForObject(baseURL + "/Attendance/" + id, Attendance.class);
        assertNotNull(updatedAttendance);
    }

    @Ignore
    public void testDeleteAttendance() {
        int id = 2;
        Attendance attendance = restTemplate.getForObject(baseURL + "/attendances/" + id, Attendance.class);
        assertNotNull(attendance);
        restTemplate.delete(baseURL + "/attendances/" + id);
        try {
            attendance = restTemplate.getForObject(baseURL + "/attendances/" + id, Attendance.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

