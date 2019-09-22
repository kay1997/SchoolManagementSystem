package com.repository.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Attendance;
import com.factory.admin.AttendanceFactory;
import com.repository.admin.impl.AttendanceRepositoryImpl;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class AttendanceRepositoryImplTest {
    AttendanceRepositoryImpl repository;
    Attendance attendance;

    @Before
    public void setUp() throws Exception {

        repository = AttendanceRepositoryImpl.getRepository();
        attendance = AttendanceFactory.getAttendance("970826", 3, "4");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(attendance);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(attendance);
        assertNotNull(repository.read(attendance.getLearnerID()));
        System.out.println("Created\n" + repository.read(attendance.getLearnerID()));
    }

    @Test
    public void read() {

        repository.create(attendance);

        Attendance attends = repository.read(attendance.getLearnerID());

        assertEquals(attendance, attends);
    }

    @Test
    public void update() {

        repository.create(attendance);

        Attendance updatedAttendance = AttendanceFactory.getAttendance("970826", 3, "5");

        repository.update(updatedAttendance);

        Assert.assertNotEquals(attendance.getNumberOfDaysPresent(), updatedAttendance.getNumberOfDaysPresent());
    }

    @Test
    public void delete() {
        repository.delete("970826");
        assertNull(repository.read("970826"));
        System.out.println("Deleted\n" + repository.read("970826"));
    }

}