package factory.admin;

import factory.admin.AttendanceFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.admin.Attendance;

public class AttendanceFactoryTest {

    @Test
    public void getNumberOfDaysAbsent() {

        int absentDays = 11;
         String presentDays = "23";

        Attendance attendance = AttendanceFactory.getAttendance(absentDays, presentDays);
        System.out.println(attendance);
        Assert.assertNotNull(attendance.getNumberOfDaysAbsent());
    }
}
