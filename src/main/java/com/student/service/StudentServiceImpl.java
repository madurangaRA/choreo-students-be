package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.student.domain.Student;
import com.student.repository.StudentRepository;
import com.student.service.validation.Message;
import com.student.service.validation.StudentValidator;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		StudentValidator.validateCreateStudentRequest(student);
		
		// check whether the student is already existed in the data base with same email address
		Student existingStudent = studentRepository.findByEmailAddressAndDeleted(student.getEmailAddress(), false);
		Assert.isNull(existingStudent, String.format(Message.STUDENT_ALREADY_EXISTED_FOR_REQUESTED_EMAIL_ADDRESS, student.getEmailAddress()));
		
		// check whether the student is already existed in the data base with same mobiel number
		existingStudent = studentRepository.findByMobileNumberAndDeleted(student.getMobileNumber(), false);
		Assert.isNull(existingStudent, String.format(Message.STUDENT_ALREADY_EXISTED_FOR_REQUESTED_MOBILE_NUMBER, student.getMobileNumber()));
		
		return studentRepository.save(student);
	}

	@Override
	public Student findById(String id) {
		StudentValidator.validateFindByIdRequest(id);
		Student existingStudent = studentRepository.findByIdAndDeleted(id, false);
		Assert.notNull(existingStudent, String.format(Message.STUDENT_NOT_EXISTED_FOR_REQUESTED_ID, id));
		return existingStudent;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findByDeleted(false);
	}

	@Override
	public Student update(String id, Student student) {
		StudentValidator.validateUpdateRequest(id, student);
		
		Student existingStudent =  studentRepository.findByIdAndDeleted(id, false);
		if(existingStudent != null) {
			existingStudent.merge(student);
		}
		return studentRepository.save(existingStudent);
	}

	@Override
	public void delete(String id) {
		StudentValidator.validateDeleteRequest(id);
		Student existingStudent =  studentRepository.findByIdAndDeleted(id, false);
		if(existingStudent != null) {
			existingStudent.setDeleted(true);
		}
		studentRepository.save(existingStudent);
	}

}
