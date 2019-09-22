package com.controller.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Attendance;
import com.factory.admin.AttendanceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SchoolManagementSystemApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttendanceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/attendance";

    @Test
    public void a_create() {

        Attendance attendance = AttendanceFactory.getAttendance("97", 4,"6");
        attendance.setLearnerID("123");

        ResponseEntity<Attendance> postResponse = restTemplate.postForEntity(baseURL + "/new", attendance, Attendance.class);

        assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_findById() {

        Attendance attendance = restTemplate.getForObject(baseURL + "/find/" + "123", Attendance.class);

        assertNotNull(attendance);
    }

    @Test
    public void c_update() {

        int id = 1;
        Attendance attendance = restTemplate.getForObject(baseURL + "/find/" + "123", Attendance.class);
        attendance.setNoOfDaysPresent("7");

        restTemplate.put(baseURL + "/update/" + "123", attendance);

        Attendance updatedAttendance = restTemplate.getForObject(baseURL + "/update/" + "123", Attendance.class);

        assertNotNull(updatedAttendance);

    }

    @Test
    public void e_delete() {

        int id = 1;
        Attendance attendance = restTemplate.getForObject(baseURL + "/find/" + "123", Attendance.class);
        assertNotNull(attendance);

        restTemplate.delete(baseURL + "/delete/" + "123");

        try {
            attendance = restTemplate.getForObject(baseURL + "/find/" + "123", Attendance.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());

    }
}