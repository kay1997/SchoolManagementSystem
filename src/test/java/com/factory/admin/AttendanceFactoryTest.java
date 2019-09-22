package com.factory.admin;

import org.junit.Assert;
import org.junit.Test;
import com.domain.admin.Attendance;

public class AttendanceFactoryTest {

    @Test
    public void getNumberOfDaysAbsent() {

        String learnerID = "9708265184084";
        int absentDays = 11;
        String presentDays = "23";

        Attendance attendance = AttendanceFactory.getAttendance(learnerID, absentDays, presentDays);
        System.out.println(attendance);
        Assert.assertNotNull(attendance.getLearnerID());
    }
}
