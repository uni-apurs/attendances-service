package com.apurs.microservices.attendancesservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apurs.microservices.attendancesservice.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	List<Attendance> findByCourseId(Integer id);
	List<Attendance> findByStudentId(Integer id);
}
