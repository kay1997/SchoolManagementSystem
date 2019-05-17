package repository.admin;

import domain.admin.Attendance;
import repository.IRepository;

import java.util.Set;

public interface AttendanceRepository extends IRepository<Attendance, String> {

    Set<Attendance> getAll();
}

