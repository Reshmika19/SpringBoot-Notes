package com.hexaware.restbasics.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.restbasics.bean.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1 , "Reshmika" , 21);
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
	    List<Student> studList = new LinkedList<>();
	    studList.add(new Student(1 , "Reshmika" , 21));
	    studList.add(new Student(2 , "Nilla" , 22));
	    studList.add(new Student(3 , "Meera" , 21));
	    studList.add(new Student(4 , "Vimal" , 25));
	    studList.add(new Student(5 , "Virat" , 28));
	    return studList;
	}

	//Path paramater
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return new Student(1 , "Reshmika" , 21);
	}
	
	@GetMapping("/student/{id}/{name}/{age}")
	public Student getStudentByName(
			@PathVariable("id") int id ,
			@PathVariable("name") String name ,
			@PathVariable("age") int age) 
	{
		return new Student(id , name , age);
	}
	
	//Request Paramater aka query Parameter
	@GetMapping("/student/query")
	public Student getStudentByIdRequestParam(@RequestParam int id) {
		return new Student(3 , "Meera" , 21);
	}
	
	@GetMapping("/student/querybyname")
	public Student getStudentByNameRequestParam(
		    @RequestParam("id") int id,
		    @RequestParam("name") String name,
		    @RequestParam("age") int age ) 
	{
	    return new Student(5 , "Virat" , 28);
	}
	
	@PostMapping("/student/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student s) {
		return s;
	}
	
	@PutMapping("/student/{id}/update")
	public Student updateStudent(@RequestBody Student s , @PathVariable int id) {
		return s;
	}

	@DeleteMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		return "Deleted Successfully...";
	}
	
	//Response
	@GetMapping("/studentResponse")
	public ResponseEntity<Student> getStudentResponse() {
		Student s =  new Student(1 , "Reshmika" , 21);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	
	//adding header
	@GetMapping("/studentResponseHeader")
	public ResponseEntity<Student> getStudentResponseHeader() {
		Student s =  new Student(1 , "Reshmika" , 21);
		ResponseEntity<Student> rE = new ResponseEntity<Student>(s,HttpStatus.OK);
		return rE.ok().header("Custom-Header", "headervalue").body(s);
	}
	
	
}
