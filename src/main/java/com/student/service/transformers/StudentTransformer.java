package com.student.service.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.student.domain.Student;
import com.student.service.dto.CreateStudentRequest;
import com.student.service.dto.StudentResponse;
import com.student.service.dto.UpdateStudentRequest;

public final class StudentTransformer {
	
	private StudentTransformer(){
		throw new RuntimeException("Identified the Reflection Attack");
	}
	
	public static Student createStudentRequestToDomain(CreateStudentRequest createRequest) {
		Student target= new Student();
		BeanUtils.copyProperties(createRequest, target);
		return target;
	}
	
	public static Student updateStudentRequestToDomain(UpdateStudentRequest updateRequest) {
		Student target = new Student();
		target.setFirstName(updateRequest.getFirstName());
		target.setLastName(updateRequest.getLastName());
		target.setAge(updateRequest.getAge());
		target.setEmailAddress(updateRequest.getEmailAddress());
		target.setMobileNumber(updateRequest.getMobileNumber());
		return target;
	}
	
	
	// converting single student domain object to student response object
	public static StudentResponse studentDomainToResponse(Student student) {
		StudentResponse target = new StudentResponse();
		BeanUtils.copyProperties(student, target);
		return target;
		
	}
	
	// converting student domain object list to student response list
	public static List<StudentResponse> studentDomainListToResponseList(List<Student> studentDomainObjectList){
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		for (Student student : studentDomainObjectList) {
			StudentResponse responseObject =   studentDomainToResponse(student);
			studentResponseList.add(responseObject);
		}
		return studentResponseList;
	}

}
