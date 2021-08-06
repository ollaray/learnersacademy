package com.simplilearn.model;



public class Subject {
	
	private int id;
	private String title;
	private String subjectType;
	
	public Subject() {
	}
	

	public Subject(String title, String subjectType) {
		super();
		this.title = title;
		this.subjectType = subjectType;
	}
	
	public Subject(int id, String title, String subjectType) {
		super();
		this.id = id;
		this.title = title;
		this.subjectType = subjectType;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", subjectType=" + subjectType + "]";
	}
	
	
}
