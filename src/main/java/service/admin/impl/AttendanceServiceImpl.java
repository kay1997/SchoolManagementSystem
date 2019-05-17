package service.admin.impl;

import domain.admin.Attendance;
import org.springframework.stereotype.Service;
import repository.admin.AttendanceRepository;
import repository.admin.impl.AttendanceRepositoryImpl;
import service.admin.AttendanceService;

import java.util.Set;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceServiceImpl service = null;
    private AttendanceRepository repository;

    private AttendanceServiceImpl() {
        this.repository = AttendanceRepositoryImpl.getRepository();
    }

    public AttendanceService getService() {
        if (service == null) service = new AttendanceServiceImpl();
        return service;
    }

    @Override
    public Attendance create(Attendance attendance) {
        return this.repository.create(attendance);
    }

    @Override
    public Attendance update(Attendance attendance) {
        return this.repository.update(attendance);
    }

    @Override
    public void delete(String attendanceNumber) {
        this.repository.delete(attendanceNumber);
    }

    @Override
    public Attendance read(String attendanceNumber) {
        return this.repository.read(attendanceNumber);
    }

    @Override
    public Set<Attendance> getAll() {
        return this.repository.getAll();
    }

}
