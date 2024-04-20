package com.student.service;

import java.util.List;

import com.student.domain.Student;

public interface StudentService {
	
	Student createStudent(Student student);
	
	Student findById(String id);
	
	List<Student> findAll();
	
	Student update(String id, Student student);
	
	void delete(String id);
	
}
