package com.simplilearn.model;

import java.util.Date;
import java.util.List;




public class Teacher {

	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String address;
	private String email;
	private String phone;
	private int classId;
	private int subjectId;
	private String created;
	private String updated;
	
	public Teacher() {
	}
	
	
	//update
	public Teacher(String firstname, String lastname, String gender, String address, String email, String phone,
			int classId, int subjectId, String updated) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.classId = classId;
		this.subjectId = subjectId;
		this.updated = updated;
	}


	//Master List
	public Teacher(int id, String firstname, String lastname, String gender, String address, String email, String phone,
			int classId, int subjectId, String created, String updated) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.classId = classId;
		this.subjectId = subjectId;
		this.created = created;
		this.updated = updated;
	}

	//insert
	public Teacher(String firstname, String lastname, String gender, String address, String email, String phone,
			int classId, int subjectId, String created, String updated) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.classId = classId;
		this.subjectId = subjectId;
		this.created = created;
		this.updated = updated;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", classId=" + classId
				+ ", subjectId=" + subjectId + ", created=" + created + ", updated=" + updated + "]";
	}
	
	

	
}
