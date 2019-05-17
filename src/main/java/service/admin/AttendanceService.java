package service.admin;

import domain.admin.Attendance;
import service.IService;

import java.util.Set;

public interface AttendanceService extends IService<Attendance, String> {

    Set<Attendance> getAll();

}
