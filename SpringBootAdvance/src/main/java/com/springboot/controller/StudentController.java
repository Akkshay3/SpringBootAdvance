package com.springboot.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exception.InvalidStudentException;
import com.springboot.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {


	private List<Student> studentList = new ArrayList<>();
	@Autowired
	Student student1;
	public StudentController() {
		studentList.add(new Student("Xyz", "Pune", 1, "8912346710", "xyz@mail.com"));
		studentList.add(new Student("ABC", "Mumbai", 2, "9988776655", "abc@hotmail.com"));
		studentList.add(new Student("PQR", "Bangalore", 3, "8710462300", "pqr@outlook.com"));
	}
	

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Student getStudentByName(@PathVariable("id") int studentId) {

		Optional<Student> std = studentList.stream().filter(stud -> stud.getRoll_no() == studentId).findFirst();
		if (std.isPresent())
			return std.get();
		throw new InvalidStudentException("Student Not Present");
	}

	@GetMapping("/query")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<List<Student>> getStudentByQueryParam(
			@RequestParam(value = "id", required = false, defaultValue="0") int studentId,
			@RequestParam(value = "name", required = false, defaultValue="") String studentName,
			@RequestParam(name = "city", required = false, defaultValue="") String studentCity) {

		    
			/*studentId.ifPresent(id -> studStream.filter(stud -> stud.getRoll_no() == id));
			studentName.ifPresent(studName -> studStream.filter(stud -> stud.getName() == studName));
			city.ifPresent(ct -> studStream.filter(stud -> stud.getCity() == ct));
			*/
			List<Predicate<Student>> studentPredicateList = new ArrayList<>();
		Predicate<Student> compositePredicate;
		    if(0 != studentId) {
		    	Predicate<Student> idPredicate = std -> std.getRoll_no() == studentId;
		    	studentPredicateList.add(idPredicate);
		    }
		    if(null != studentName && !studentName.isEmpty()) {
		    	Predicate<Student> namePredicate = std -> std.getName().equals(studentName);
		    	studentPredicateList.add(namePredicate);
		    }
		    if(null != studentCity && !studentCity.isEmpty()) {
		    	Predicate<Student> cityPredicate = std-> std.getCity().equals(studentCity);
		    	studentPredicateList.add(cityPredicate);
		    }
		    
		    compositePredicate = studentPredicateList.stream().reduce(w->true,Predicate ::and);
			List<Student>studentsList =  studentList.stream()
													.filter(compositePredicate)
													.collect(Collectors.toList());
		
		if (studentsList.size() > 0)
			return ResponseEntity.ok(studentsList);
		else
			throw new InvalidStudentException("Student Not Present");
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<List<Student>> getAllStudents() {
	//studentList.add(student1);
		return ResponseEntity.ok(studentList);
		
	}

	@PostMapping
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student std) {
		studentList.add(std);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(std.getRoll_no()).toUri();
		return ResponseEntity.created(location).build();
	}
    
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int studentId) {
	     Optional<Student> std= studentList.stream()
	      .filter(p -> p.getRoll_no() == studentId)
	      .findFirst();
	     
	    if(std.isPresent()) {
	    	studentList.remove(std.get());
	    	return ResponseEntity.ok(std.get());
	    }
	     
		return ResponseEntity.notFound().build();
	}
		
}
