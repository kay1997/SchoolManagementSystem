package com.factory.admin;

import com.domain.admin.Attendance;

public class AttendanceFactory {

    public static Attendance getAttendance(int daysAbsent, String daysPresent) {
        return new Attendance.Builder().noOfDaysAbsent(daysAbsent)
                .noOfDaysPresent(daysPresent)
                .build();
    }
}

