package com.wipro.spring.mongo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.spring.mongo.entity.Student;
import com.wipro.spring.mongo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	private final StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	public Student addStudent(Student student) {
		return repository.save(student);
	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}
}
