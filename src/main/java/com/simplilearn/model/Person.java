package com.simplilearn.model;

import java.util.Date;

public class Person<T> {
	private Integer id;
	private String firstname;
	private String lastname;
	private String gender;
	private String address;
	private String email;
	private String phone;
	private Date created;
	private Date updated;
	
	
	
	public Person() {
		
	}
	
	public Person(Integer id, String firstname, String lastname, String gender, String address, String email,
			String phone, Date created, Date updated) {
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
	}
	
	
	public Person(String firstname, String lastname, String gender, String address, String email, String phone,
			Date created, Date updated) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.created = created;
		this.updated = updated;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	
	
	
}
