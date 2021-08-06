package com.simplilearn.model;


public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String gender;
	private String created;
	private String updated;
	private String group;
	private int status;
	
	public User() {
		
	}
	
	
	public User(int id, String firstname, String lastname, String email, String password, String gender,
			String created, String updated, String group, int status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.created = created;
		this.updated = updated;
		this.group = group;
		this.status = status;
	}
	
	public User(String firstname, String lastname, String email, String password, String gender,
			String created, String updated, String group, int status) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.created = created;
		this.updated = updated;
		this.group = group;
		this.status = status;
	}
	
	public User(int id, String firstname, String lastname, String email, String gender,
			String created, String updated, String group, int status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.created = created;
		this.updated = updated;
		this.group = group;
		this.status = status;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", created=" + created + ", updated=" + updated
				+ ", group=" + group + ", status=" + status + "]";
	}

	

	
	
	
}
