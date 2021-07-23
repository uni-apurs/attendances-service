package com.apurs.microservices.attendancesservice.dto;

import java.time.ZonedDateTime;

public class AttendanceUpdateDTO {
	private int id;
	private int courseId;
	private int studentId;
	private ZonedDateTime updatedAt;
	
	public AttendanceUpdateDTO(int id, int courseId, int studentId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.studentId = studentId;
		this.setUpdatedAt(ZonedDateTime.now());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
