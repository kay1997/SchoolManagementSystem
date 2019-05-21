package com.service.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Attendance;
import com.factory.admin.AttendanceFactory;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class AttendanceServiceTest {

    private AttendanceRepository repository;
    private Attendance attendance;

    private Attendance getSavedAttendance() {
        Set<Attendance> savedAttendances = this.repository.getAll();
        return savedAttendances.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AttendanceRepositoryImpl.getRepository();
        this.attendance = AttendanceFactory.getAttendance(12, "57");
    }

    @Test
    public void a_create() {
        Attendance created = this.repository.create(this.attendance);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.attendance);
    }

    @Test
    public void b_read() {
        Attendance savedAttendance = getSavedAttendance();
        System.out.println("In read, days present = " + savedAttendance.getNumberOfDaysPresent());
        Attendance read = this.repository.read(savedAttendance.getNumberOfDaysPresent());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAttendance, read);
    }

    @Test
    public void e_delete() {
        Attendance savedAttendance = getSavedAttendance();
        this.repository.delete(savedAttendance.getNumberOfDaysPresent());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newAttendanceNumber = "New Test days present";
        Attendance updated = new Attendance.Builder().copy(getSavedAttendance()).noOfDaysPresent(newAttendanceNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAttendanceNumber, updated.getNumberOfDaysPresent());
    }

    @Test
    public void d_getAll() {
        Set<Attendance> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}