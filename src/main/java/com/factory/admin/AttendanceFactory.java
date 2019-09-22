package com.factory.admin;

import com.domain.admin.Attendance;

public class AttendanceFactory {

    public static Attendance getAttendance(String learnerID, int daysAbsent, String daysPresent) {
        return new Attendance.Builder().learnerID(learnerID).noOfDaysAbsent(daysAbsent)
                .noOfDaysPresent(daysPresent)
                .build();
    }
}

