package com.simplilearn.model;

public class Student {

	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String address;
	private String email;
	private String phone;
	private String created;
	private String updated;
	private int classId;
	
	
	public Student() {
		
	}

	//Master List
	public Student(int id, String firstname, String lastname, String gender, String address, String email,
			String phone, String created, String updated, int classId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.created = created;
		this.updated = updated;
		this.classId = classId;
	}
	//Update 
	public Student(String firstname, String lastname, String gender, String address, String email, String phone,
			 String updated, int classId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.updated = updated;
		this.classId = classId;
	}
	
	//insert
	public Student(String firstname, String lastname, String gender, String address, String email, String phone,
			String created, String updated, int classId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.created = created;
		this.updated = updated;
		this.classId = classId;
	}
	
	

	public int getclassId() {
		return classId;
	}



	public void setclassId(int classId) {
		this.classId = classId;
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
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", created=" + created
				+ ", updated=" + updated + ", classId=" + classId + "]";
	}

	
	
	
	
	
	
	
}
