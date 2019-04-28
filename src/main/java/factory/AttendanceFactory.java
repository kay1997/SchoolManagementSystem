package factory;

import domain.Attendance;

public class AttendanceFactory {

    public static Attendance getAttendance(int daysAbsent, String daysPresent) {
        return new Attendance.Builder().noOfDaysAbsent(daysAbsent)
                .noOfDaysPresent(daysPresent)
                .build();
    }
}

