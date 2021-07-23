package com.apurs.microservices.attendancesservice.service;

import java.util.List;

import com.apurs.microservices.attendancesservice.dto.AttendanceCreateDTO;
import com.apurs.microservices.attendancesservice.dto.AttendanceDTO;
import com.apurs.microservices.attendancesservice.dto.AttendanceUpdateDTO;

public interface AttendanceService {
	public abstract List<AttendanceDTO> findAll();
	public abstract AttendanceDTO findOne(Integer id);
	public abstract AttendanceDTO insert(AttendanceCreateDTO attendance) throws Exception;
	public abstract AttendanceDTO update(AttendanceUpdateDTO attendance) throws Exception;
	public abstract boolean delete(Integer id);
}
