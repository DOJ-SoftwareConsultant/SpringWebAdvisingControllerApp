package com.doj.spring.web.exception.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.doj.spring.web.bean.Student;
import com.doj.spring.web.bean.StudentValidator;
import com.doj.spring.web.exception.StudentNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ModelAndView handleStudentNotFoundException(StudentNotFoundException ex) {
		Map<String, StudentNotFoundException> model = new HashMap<String, StudentNotFoundException>();
		model.put("exception", ex);
		return new ModelAndView("student.error", model);

	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		Map<String, Exception> model = new HashMap<String, Exception>();
		model.put("exception", ex);
		return new ModelAndView("error", model);

	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("fname");
		binder.setValidator(new StudentValidator());
	}
	
	@ModelAttribute
	public Student register(Locale currentLocale){
		Student student = new Student();
		student.setAddress(currentLocale.getDisplayName());
		return student;
		
	}
}
