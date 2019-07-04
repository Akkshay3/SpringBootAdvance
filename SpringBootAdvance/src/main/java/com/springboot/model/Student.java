package com.springboot.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Student {
	@Size(min=4, message="Student Name should contain atleast Four characters")
	@NotNull
	private String name;
	
	@NotBlank(message="City Name should not be Blank")
	@NotNull
	private String city;
	
	@NotNull
	@Size(max=10,min=10 , message = "Please Enter valid Mobile No")
	private String contactNo;
	@Email(message="Enter valid Email Address")
	private String emailId; 

	private int roll_no;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student( String name,String city, int roll_no,String contactNo,String emailId) {
		super();
		this.name = name;
		this.city = city;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.roll_no = roll_no;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", roll_no=" + roll_no + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roll_no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roll_no != other.roll_no)
			return false;
		return true;
	}

}
