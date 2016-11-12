package com.usermanagement.commons.dto;

import com.usermanagement.commons.model.User.Gender;
import com.usermanagement.commons.model.User.Role;
import com.usermanagement.commons.model.User.Status;

public class UserDTO extends BaseDTO {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String userName;
	private String password;
	private String address;
	private Long contactNo1;
	private Long contactNo2;
	private Status status;
	private Gender gender;	
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Long getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(Long contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public Long getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(Long contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	
}
