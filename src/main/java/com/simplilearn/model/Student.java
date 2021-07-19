package com.simplilearn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="std_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String gender;
	private String address;
	private String email;
	private String phone;
	private Date created;
	private Date updated;
	
	
	
	public Student() {
		
	}

	public Student(Integer id, String firstname, String lastname, String gender, String address, String email,
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
	
	
	public Student(String firstname, String lastname, String gender, String address, String email, String phone,
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

	


	public Student(String firstname, String lastname, String gender, String address, String email, String phone,
			Date updated) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
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
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	
	
	
	
	
	
}
