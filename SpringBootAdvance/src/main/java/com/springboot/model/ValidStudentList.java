package com.springboot.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

@Component
public class ValidStudentList {
	@Valid
	List<Student> listOfStudent;
	

	public List<Student> getListOfStudent() {
		return listOfStudent;
	}

	public void setListOfStudent(List<Student> listOfStudent) {
		this.listOfStudent = listOfStudent;
	}

	public ValidStudentList() {
		super();
		this.listOfStudent = new ArrayList<Student>();
	}

	public ValidStudentList(List<Student> studentList) {
		this();
		this.listOfStudent = studentList;
	}
	
}
