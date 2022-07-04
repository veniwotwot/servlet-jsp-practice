package com.reg.model;

public class Employee {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String contact;

	public Employee() {
		
	}
	
	public Employee(String f, String l, String u, String p, String addr, String c) {
		firstName = f;
		lastName = l;
		username = u;
		password = p;
		address = addr;
		contact = c;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
