package com.student.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.TestTemplate;
import com.student.repository.StudentRepository;

public class StudentServiceTest extends TestTemplate{
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@Test
	public void createStudentServiceTest() {
		
	}

}
