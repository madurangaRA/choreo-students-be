package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	
	Student findByEmailAddressAndDeleted(String emailAddress, boolean deleted);
	
	Student findByMobileNumberAndDeleted(String mobileNumber, boolean deleted);
	
	Student findByIdAndDeleted(String id, boolean deleted);
	
	List<Student> findByDeleted(boolean deleted);

}
