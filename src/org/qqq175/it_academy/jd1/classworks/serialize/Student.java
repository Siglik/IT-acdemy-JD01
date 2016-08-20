package org.qqq175.it_academy.jd1.classworks.serialize;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4840682880344936062L;
	private int id;
	private String name;
	private Date dateOfBirth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public Student(int id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "id= " + id + ", name= " + name + ", dateOfBirth= "
				+ dateOfBirth;
	}
	
}
