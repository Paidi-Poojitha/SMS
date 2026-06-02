package com.sms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String department;
	private double cgpa;
	private long phno;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String department, double cgpa, long phno) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.cgpa = cgpa;
		this.phno = phno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "Student : id=" + id + ", name=" + name + ", department=" + department + ", cgpa=" + cgpa + ", phno="
				+ phno;
	}
	
}
