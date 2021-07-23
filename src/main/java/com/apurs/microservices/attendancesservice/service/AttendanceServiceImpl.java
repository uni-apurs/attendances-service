package com.apurs.microservices.attendancesservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apurs.microservices.attendancesservice.dto.AttendanceCreateDTO;
import com.apurs.microservices.attendancesservice.dto.AttendanceDTO;
import com.apurs.microservices.attendancesservice.dto.AttendanceUpdateDTO;
import com.apurs.microservices.attendancesservice.model.Attendance;
import com.apurs.microservices.attendancesservice.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	private AttendanceRepository attendanceRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	private ModelMapper modelMapper = new ModelMapper();

	@Value("${app.coursesEndpoint}")
	private String coursesEndpoint;
	
	@Value("${app.studentsEndpoint}")
	private String studentsEndpoint;
	
	public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
		this.attendanceRepository = attendanceRepository;
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	@Override
	public List<AttendanceDTO> findAll() {
		List<Attendance> attendances = attendanceRepository.findAll();
		List<AttendanceDTO> dtos = new ArrayList<AttendanceDTO>();
		
		for (Attendance attendance : attendances)
			dtos.add(modelMapper.map(attendance, AttendanceDTO.class));
		
		return dtos;
	}

	@Override
	public AttendanceDTO findOne(Integer id) {
		Attendance attendance = attendanceRepository.getById(id);
		return modelMapper.map(attendance, AttendanceDTO.class);
	}

	@Override
	public AttendanceDTO insert(AttendanceCreateDTO attendance) throws Exception {
		ResponseEntity<String> resCourse = restTemplate.getForEntity(coursesEndpoint + attendance.getCourseId(), String.class);
		ResponseEntity<String> resStudent = restTemplate.getForEntity(studentsEndpoint + attendance.getStudentId(), String.class);

		if (!resCourse.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid courseId.");
	
		if (!resStudent.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid studentId.");
		
		Attendance createAttendance = modelMapper.map(attendance, Attendance.class);
		createAttendance = attendanceRepository.save(createAttendance);
		return modelMapper.map(createAttendance, AttendanceDTO.class);
	}

	@Override
	public AttendanceDTO update(AttendanceUpdateDTO attendance) throws Exception {
		if(!attendanceRepository.existsById(attendance.getId()))
			return null;
		
		ResponseEntity<String> resCourse = restTemplate.getForEntity(coursesEndpoint + attendance.getCourseId(), String.class);
		ResponseEntity<String> resStudent = restTemplate.getForEntity(studentsEndpoint + attendance.getStudentId(), String.class);

		if (!resCourse.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid courseId.");
	
		if (!resStudent.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid studentId.");
		
		Attendance tempAttendance = attendanceRepository.getById(attendance.getId());
		Attendance updateAttendance = modelMapper.map(attendance, Attendance.class);
		updateAttendance.setCreatedAt(tempAttendance.getCreatedAt());
		updateAttendance = attendanceRepository.save(updateAttendance);
		return modelMapper.map(updateAttendance, AttendanceDTO.class);
	}

	@Override
	public boolean delete(Integer id) {
		if(!attendanceRepository.existsById(id))
			return false;
		
		attendanceRepository.deleteById(id);
		return true;
	}
	
}
