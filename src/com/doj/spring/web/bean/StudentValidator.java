package com.doj.spring.web.bean;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "fname", "required", "Enter First name");
		ValidationUtils.rejectIfEmpty(errors, "lname", "required", "Enter Last name");
		ValidationUtils.rejectIfEmpty(errors, "address", "required", "Enter address");
		ValidationUtils.rejectIfEmpty(errors, "course", "required", "Enter course name");
		ValidationUtils.rejectIfEmpty(errors, "age", "required", "Enter Age");
	}

}
