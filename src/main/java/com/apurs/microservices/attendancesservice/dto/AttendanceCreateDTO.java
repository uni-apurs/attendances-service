package com.apurs.microservices.attendancesservice.dto;

import java.time.ZonedDateTime;

public class AttendanceCreateDTO {
	private int courseId;
	private int studentId;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	public AttendanceCreateDTO(int courseId, int studentId, ZonedDateTime createdAt) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		this.createdAt = createdAt;
		this.setUpdatedAt(ZonedDateTime.now());
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

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
