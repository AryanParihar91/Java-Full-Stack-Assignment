package com.wipro.spring.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.mongo.entity.Student;
import com.wipro.spring.mongo.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentServiceImpl service;

	public StudentController(StudentServiceImpl service) {
		this.service = service;
	}

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}

	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

}