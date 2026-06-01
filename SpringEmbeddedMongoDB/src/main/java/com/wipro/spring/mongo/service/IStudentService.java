package com.wipro.spring.mongo.service;

import java.util.List;

import com.wipro.spring.mongo.entity.Student;

public interface IStudentService {

	public Student addStudent(Student student);

	public List<Student> getAllStudents();

}
