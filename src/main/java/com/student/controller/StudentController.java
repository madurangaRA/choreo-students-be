package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.student.common.RequestMapper;
import com.student.domain.Student;
import com.student.service.StudentService;
import com.student.service.dto.CreateStudentRequest;
import com.student.service.dto.StudentResponse;
import com.student.service.dto.StudentsResponse;
import com.student.service.dto.UpdateStudentRequest;
import com.student.service.transformers.StudentTransformer;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// create a student
	@RequestMapping(value = RequestMapper.CREATE_STUDENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody StudentResponse create(@RequestBody CreateStudentRequest createStudentRequest) {
		Student student = StudentTransformer.createStudentRequestToDomain(createStudentRequest);
		Student createdStudent = studentService.createStudent(student);
		return StudentTransformer.studentDomainToResponse(createdStudent);
	}
	
	
	// read a student by Id
	@RequestMapping(value = RequestMapper.RETRIEVE_STUDENT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody StudentResponse findById(@PathVariable String id) {
		Student student = studentService.findById(id);
		StudentResponse response = StudentTransformer.studentDomainToResponse(student);
		return response;
	}
	
	// read all students
	@RequestMapping(value = RequestMapper.RETRIEVE_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody StudentsResponse findAll() {
		List<Student> studentDomainObjectList = studentService.findAll();
		List<StudentResponse> responseObjectList = StudentTransformer.studentDomainListToResponseList(studentDomainObjectList);
		StudentsResponse response = new StudentsResponse();
		response.setStudents(responseObjectList);
		return response;
	}
	
	// updating an existing student
	@RequestMapping(value = RequestMapper.UPDATE_STUDENT, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody StudentResponse update(@PathVariable String id, @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student = StudentTransformer.updateStudentRequestToDomain(updateStudentRequest);
		Student updatedStudent = studentService.update(id, student);
		return StudentTransformer.studentDomainToResponse(updatedStudent);
	}
	
	// delete student
	@RequestMapping(value = RequestMapper.DELETE_STUDENT, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable String id) {
		studentService.delete(id);
	}
	
}












