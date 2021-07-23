package com.apurs.microservices.attendancesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apurs.microservices.attendancesservice.dto.AttendanceCreateDTO;
import com.apurs.microservices.attendancesservice.dto.AttendanceDTO;
import com.apurs.microservices.attendancesservice.dto.AttendanceUpdateDTO;
import com.apurs.microservices.attendancesservice.service.AttendanceService;

@RestController
@RequestMapping("/attendances")
public class AttendanceRestController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@GetMapping("")
	public List<AttendanceDTO> getAttendances(){
		return attendanceService.findAll();
	}
	
	@GetMapping("/{id}")
	public AttendanceDTO getAttendance(@PathVariable("id") Integer id) {
		return attendanceService.findOne(id);
	}
	
	@PostMapping("")
	public ResponseEntity<AttendanceDTO> insertAttendance(@RequestBody AttendanceCreateDTO attendance) throws Exception {
		if (attendanceService.insert(attendance) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("")
	public ResponseEntity<AttendanceDTO> updateAttendance(@RequestBody AttendanceUpdateDTO attendance) throws Exception {
		if (attendanceService.update(attendance) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AttendanceDTO> deleteAttendance(@PathVariable("id") Integer id) {
		if (attendanceService.delete(id))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
