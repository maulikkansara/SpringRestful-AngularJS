package com.usermanagement.commons.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "user_account")
public class User extends BaseModel { 

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
 
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String middleName;

	@Column
	private String email;
		
	@Column
	private String userName;

	@Column(length = 1024) 
	private String password;
	
	@Column 
	private String address;
	
	@Column 
	private Long contactNo1;
	
	@Column 
	private Long contactNo2;
		
	public enum Status {
		REGISTERED, ACTIVE, INACTIVE, SUSPENDED;
	}
	
	public enum Gender {
		MALE, FEMALE;
	}
	
	public enum Role {
		ADMIN,USER;
	}

	@Basic
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Basic
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Basic
	@Enumerated(EnumType.STRING)
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
