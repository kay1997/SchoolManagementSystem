package com.repository.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Attendance;
import com.factory.admin.AttendanceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class AttendanceRepositoryImplTest {
    @Autowired
    private AttendanceRepository repository;
    private String attendanceNo = null;

    @Test
    public void CreateAttendanceTest() throws IOException {
        Attendance attendance = AttendanceFactory.getAttendance(2, "3");
        Attendance result = repository.create(attendance);
        attendanceNo = result.getNumberOfDaysPresent();
        Assert.assertNotNull(attendance);
    }

    @Test
    public void GetAttendanceTest() throws IOException {

        Attendance attendance = repository.read(attendanceNo);
        Assert.assertNotNull(attendance);
    }
}