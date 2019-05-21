package com.repository.admin;

import com.domain.admin.Attendance;
import com.repository.IRepository;

import java.util.Set;

public interface AttendanceRepository extends IRepository<Attendance, String> {

    Set<Attendance> getAll();
}

