package com.student.service.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.Assert;

import com.student.domain.Student;

public class StudentValidator {

	public static final int MIN_AGE = 18;
	public static final int MAX_AGE = 24;
	
	private static final String MOBILE_NUMBER_PATTERN= "[0-9]{10}";
	public static final String EMAIL_ADDRESS_PATTERN= "^\\w+?(\\w|\\.|\\-|\\+)*\\@(((\\w+?(\\w|\\-)*?\\w)|(\\w))\\.)+\\w+$";
	public static final String UUID_PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";
	
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	
	public static void validateCreateStudentRequest(Student createRequest) {
		Assert.hasText(createRequest.getFirstName(), Message.INVALID_FIRST_NAME);
		Assert.hasText(createRequest.getLastName(), Message.INVALID_LAST_NAME);
		Assert.isTrue(isValidAge(createRequest.getAge()), Message.INVALID_AGE);
		Assert.isTrue(isValidDate(createRequest.getBirthDay()), Message.INVALID_BIRTHDAY);
		Assert.isTrue(isValidDateTimeFormat(createRequest.getBirthDay()), Message.INVALID_DATE_FORMAT);
		Assert.isTrue(isValidMobileNumber(createRequest.getMobileNumber()), Message.INVALID_MOBILE_NUMBER);
		Assert.isTrue(isValidEmailAddress(createRequest.getEmailAddress()), Message.INVALID_EMAIL_ADDRESS);
	}
	
	public static void validateFindByIdRequest(String id) {
		Assert.isTrue(isValidUUID(id), String.format(Message.INVALID_UUID, id));
	}
	
	public static void validateUpdateRequest(String id, Student updateRequest) {
		Assert.isTrue(isValidUUID(id), String.format(Message.INVALID_UUID, id));
		Assert.hasText(updateRequest.getFirstName(), Message.INVALID_FIRST_NAME);
		Assert.hasText(updateRequest.getLastName(), Message.INVALID_LAST_NAME);
		Assert.isTrue(isValidAge(updateRequest.getAge()), Message.INVALID_AGE);
		Assert.isTrue(isValidDate(updateRequest.getBirthDay()), Message.INVALID_BIRTHDAY);
		Assert.isTrue(isValidDateTimeFormat(updateRequest.getBirthDay()), Message.INVALID_DATE_FORMAT);
		Assert.isTrue(isValidMobileNumber(updateRequest.getMobileNumber()), Message.INVALID_MOBILE_NUMBER);
		Assert.isTrue(isValidEmailAddress(updateRequest.getEmailAddress()), Message.INVALID_EMAIL_ADDRESS);
	}
		
	public static void validateDeleteRequest(String id) {
		Assert.isTrue(isValidUUID(id), String.format(Message.INVALID_UUID, id));
	}

	private static boolean isValidAge(int age) {
		boolean isAgeValid = true;
		if (age < 0) {
			isAgeValid = false;
		}
		if (!(age >= MIN_AGE && age <= MAX_AGE)) {
			isAgeValid = false;
		}
		return isAgeValid;
	}

	private static boolean isValidDate(Date date) {
		return date.before(new Date());
	}

	private static boolean isValidDateTimeFormat(Date date) {
		boolean isDateTimeFormatValid = true;
		if (date == null) {
			isDateTimeFormatValid = false;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);

		try {
			simpleDateFormat.format(date);
		} catch (Exception e) {
			isDateTimeFormatValid = false;
		}
		return isDateTimeFormatValid;
	}
	
	private static boolean isValidMobileNumber(String mobileNumber) {
		return mobileNumber.matches(MOBILE_NUMBER_PATTERN);
	}
	
	private static boolean isValidEmailAddress(String email) {
		return email.matches(EMAIL_ADDRESS_PATTERN);
	}
	
	private static boolean isValidUUID(String id) {
		return id.matches(UUID_PATTERN);
	}

	

	

	

}
