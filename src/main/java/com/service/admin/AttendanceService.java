package com.service.admin;

import com.domain.admin.Attendance;
import com.service.IService;

import java.util.Set;

public interface AttendanceService extends IService<Attendance, String> {

    Set<Attendance> getAll();

}
