package repository.admin.impl;

import domain.admin.Attendance;
import repository.admin.AttendanceRepository;

import java.util.HashSet;
import java.util.Set;

public class AttendanceRepositoryImpl implements AttendanceRepository{

    private static AttendanceRepositoryImpl repository = null;
    private Set<Attendance> attendances;

    private AttendanceRepositoryImpl(){
        this.attendances = new HashSet<>();
    }

    public static AttendanceRepositoryImpl getRepository(){
        if (repository == null) repository = new AttendanceRepositoryImpl();
        return repository;
    }


    public Attendance create(Attendance attendance){
        this.attendances.add(attendance);
        return attendance;
    }

    private Attendance findAttendance(String attendanceNumber) {
        return this.attendances.stream()
                .filter(attendance -> attendance.getNumberOfDaysPresent().trim().equals(attendanceNumber))
                .findAny()
                .orElse(null);
    }

    public Attendance read(String attendanceNumber){

        Attendance attendance = findAttendance(attendanceNumber);
        return attendance;
    }

    public void delete(String attendanceNumber) {
        Attendance attendance = findAttendance(attendanceNumber);
        if (attendance != null) this.attendances.remove(attendance);

    }

    public Attendance update(Attendance attendance) {
        Attendance toDelete = findAttendance(attendance.getNumberOfDaysPresent());
        if (toDelete != null) {
            this.attendances.remove(toDelete);
            return create(attendance);
        }
        return null;
    }



    public Set<Attendance> getAll(){
        return this.attendances;
    }
}

