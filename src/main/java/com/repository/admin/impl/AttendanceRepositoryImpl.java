package com.repository.admin.impl;

import com.domain.admin.Attendance;
import com.repository.admin.AttendanceRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class AttendanceRepositoryImpl implements AttendanceRepository {

   private static AttendanceRepositoryImpl repository = null;
   private Map<String, Attendance> attendances;

   private AttendanceRepositoryImpl() {
      this.attendances = new HashMap<>();
   }

   public static AttendanceRepositoryImpl getRepository() {
      if (repository == null) repository = new AttendanceRepositoryImpl();
      return repository;
   }

   @Override
   public Set<Attendance> getAll() {
      Collection<Attendance> attendances = this.attendances.values();
      Set<Attendance> set = new HashSet<>();
      set.addAll(attendances);
      return set;
   }

   @Override
   public Attendance create(Attendance attendance) {
      if (read(attendance.getLearnerID()) == null) {
         this.attendances.put(attendance.getLearnerID(), attendance);
      }
      return attendance;
   }

   @Override
   public Attendance read(String e) {
      return this.attendances.get(e);
   }

   @Override
   public Attendance update(Attendance attendance) {
      if (read(attendance.getLearnerID()) != null) {
         attendances.replace(attendance.getLearnerID(), attendance);
      }
      return attendance;
   }

   @Override
   public void delete(String e) {
      Attendance attendance = read(e);
      this.attendances.remove(e, attendance);
   }

}