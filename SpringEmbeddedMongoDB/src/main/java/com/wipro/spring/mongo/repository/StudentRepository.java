package com.wipro.spring.mongo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.spring.mongo.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}