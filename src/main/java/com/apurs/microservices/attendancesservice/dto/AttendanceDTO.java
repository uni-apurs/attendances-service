package com.apurs.microservices.attendancesservice.dto;

public class AttendanceDTO {
	private int id;
	private int courseId;
	private int studentId;
	
	public AttendanceDTO() {
		super();
	}

	public AttendanceDTO(int id, int courseId, int studentId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.studentId = studentId;
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
}
