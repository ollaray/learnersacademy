package com.simplilearn.model;

import java.util.List;

public class ClassList {
	
	private int id;
	private String className;
	
	public ClassList() {
	}
	
	public ClassList(String className) {
		super();
		this.className = className;
	}
	public ClassList(int id, String className) {
		super();
		this.id = id;
		this.className = className;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ClassList [id=" + id + ", className=" + className + "]";
	}



	
	
	
}
