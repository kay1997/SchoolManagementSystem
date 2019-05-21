package com.service.admin.impl;

import com.domain.admin.Attendance;
import com.service.admin.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.repository.admin.AttendanceRepository;
import com.repository.admin.impl.AttendanceRepositoryImpl;

import java.util.Set;

@Service("ServiceImpl")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    @Qualifier("InMemory")
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
