package com.student.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "birthdate")
	private Date birthDay;

	@Column(name = "mobilenumber")
	private String mobileNumber;

	@Column(name = "emailaddress")
	private String emailAddress;
	
	@Column(name = "deleted")
	private boolean deleted;

	public Student() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	// updating the existing object data with request data
	public void merge(Student request) {
		if(request.firstName != this.firstName && request.firstName != null && !request.firstName.isEmpty() ) {
			this.firstName = request.firstName;
		}
		if(request.lastName != this.lastName && request.lastName != null && !request.lastName.isEmpty() ) {
			this.lastName = request.lastName;
		}
		if(request.age != this.age && !(request.age <=0 )) {
			this.age = request.age;
		}
		if(request.mobileNumber != this.mobileNumber && request.mobileNumber != null && !request.mobileNumber.isEmpty() ) {
			this.mobileNumber = request.mobileNumber;
		}
		if(request.emailAddress != this.emailAddress && request.emailAddress != null && !request.emailAddress.isEmpty() ) {
			this.emailAddress = request.emailAddress;
		}
	}
	
}
