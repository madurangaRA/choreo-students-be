package com.student.service.validation;

public interface Message {
	
	public static final String INVALID_FIRST_NAME = "student first name must not be null or empty";
	public static final String INVALID_LAST_NAME = "student last name must not be null or empty";
	public static final String INVALID_AGE = "student age is invalid";
	public static final String INVALID_BIRTHDAY = "Invaid birth day";
	public static final String INVALID_DATE_FORMAT = "Invalid Date Format";
	public static final String INVALID_MOBILE_NUMBER = "Invalid Mobile Number";
	public static final String INVALID_EMAIL_ADDRESS = "Invalid Email Address";
	
	
	public static final String STUDENT_ALREADY_EXISTED_FOR_REQUESTED_EMAIL_ADDRESS = "student is already existed with the requested email address : [ %1$s ]";
	public static final String STUDENT_ALREADY_EXISTED_FOR_REQUESTED_MOBILE_NUMBER = "student is already existed with the requested mobile number : [ %1$s ]";
	public static final String STUDENT_NOT_EXISTED_FOR_REQUESTED_ID = "student is not existed for the requested Id [ %1$s]";
	public static final String INVALID_UUID = "Invaid UUID [ %1$s ]";

}
