package com.task_rest_app.dto;

public class StudentReqDto {

	private String fname;
	private String lname;
	private String email;

	public StudentReqDto(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentReqDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
