package com.service.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Attendance;
import com.factory.admin.AttendanceFactory;
import com.service.admin.impl.AttendanceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.AttendanceRepository;
import com.repository.admin.impl.AttendanceRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class AttendanceServiceTest {

    AttendanceServiceImpl service;
    Attendance attendance;

    @Before
    public void setUp() throws Exception {
        service = AttendanceServiceImpl.getService();
        attendance = AttendanceFactory.getAttendance("12345", 3,"4");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(attendance);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(attendance);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @Test
    public void update() {
        service.create(attendance);
        System.out.println(service.read("12345"));

        Attendance attendanceUpdated = AttendanceFactory.getAttendance("12345", 3,"6");
        service.update(attendanceUpdated);

        Attendance comp = service.read("12345");
        Assert.assertNotEquals(attendance.getNumberOfDaysPresent(), comp.getNumberOfDaysPresent());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(attendance.getLearnerID()));
        System.out.println("Delete\n" + service.read(attendance.getLearnerID()));
    }

}