package com.doj.spring.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.doj.spring.web.bean.Student;
import com.doj.spring.web.exception.StudentNotFoundException;

@Controller
public class WebController{
	
	static Map<String, Student> map = new HashMap<String, Student>();
	
	//multiple mapping with one remote method
	@RequestMapping(value={"/", "/index","/home","/welcome"})
	public String home(){
		Student student = new Student();
		student.setFname("Dinesh");
		student.setLname("Rajput");
		student.setAge("29");
		student.setAddress("Noida");
		student.setCourse("MS");
		map.put("1000", student);
		return "home";
	}
	
	//With Model and Model Name to View Resolver
	@RequestMapping("/indexc")
	public ModelAndView welcome(){
		Map<String, String> model = new HashMap<>();
		model.put("name", "Sumit");
		return new ModelAndView("home","model", model);
	}
	
	//We are using Spring ModelMap for return the model value
	@RequestMapping("/hello")
	public String index(ModelMap model){
		model.put("name", "Sumit");
		return "home";
	}
	
	//We are using Spring ModelMap and fetching request parameter here
	@RequestMapping("/doj")
	public String hello(ModelMap model, HttpServletRequest request){
		String name = request.getParameter("name");
		model.put("name", name);
		return "home";
	}
	
	//We are using Spring ModelMap and Mapping the attribte with request param annotation with attributes whatever is ur requirement 
	@RequestMapping("/dojc")
	public String doj(ModelMap model, @RequestParam(defaultValue = "DOJ Students", required=true, value="fname") String name, 
			@RequestParam(required = false, value="lname") String sname){
		if(sname != null){
			name = name +" "+ sname;
		}
		model.put("name", name);
		return "home";
	}
	
	@RequestMapping("/doj-student-{fname}-{lname}")
	public String dojStudent(ModelMap model, @PathVariable(value="fname") String name, @PathVariable(value="lname") String sname,
			@RequestParam String address){
		if(sname != null){
			name = name +" "+ sname;
		}
		model.put("name", name);
		return "home";
	}
	
	@RequestMapping(value="/doj-student", method=RequestMethod.GET)
	public String getDojStudent(ModelMap model, Student student){
		String name = null;
		if(student.getFname() != null){
			name = student.getFname();
		}
		if(student.getLname() != null){
			name = name + " " +student.getLname();
		}
		if(student.getAddress() != null){
			name = name+" "+student.getAddress();
		}
		if(student.getCourse() != null){
			name = name+" "+student.getCourse();
		}
		model.put("name", name);
		return "home";
	}
	
	@RequestMapping(value = "/dojstudent", method=RequestMethod.GET)
	public String student(){
		return "student";
	}
	
	@RequestMapping(value="/dojstudent", method=RequestMethod.POST)
	public String getStudent(ModelMap model, @Valid Student student, Errors errors, @RequestPart("profilePicture") MultipartFile profilePicture){
		if(errors.hasErrors()){
			System.out.println("Errors "+errors.getErrorCount());
			return "student";
		}
		try {
			profilePicture.transferTo(new File("E:\\Shiksha\\Programming\\DOJWorkspace\\"+profilePicture.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		String name = null;
		if(student.getFname() != null){
			name = student.getFname();
		}
		if(student.getLname() != null){
			name = name + " " +student.getLname();
		}
		if(student.getAddress() != null){
			name = name+" "+student.getAddress();
		}
		if(student.getCourse() != null){
			name = name+" "+student.getCourse();
		}
		model.put("name", name);
		return "home";
	}
	
	@RequestMapping("/doj-student-{rollNumber}")
	public String dojStudentByRollNumber(ModelMap model, @PathVariable(value="rollNumber") String rollNumber){
		Student student = map.get(rollNumber);
		if (student == null) {
			throw new StudentNotFoundException("Student Not Found", "MYAPPERROR-404");
		}
		String name = student.getFname()+" "+student.getLname()+" "+student.getAddress()+" "+student.getCourse();
		model.put("name", name);
		return "home";
	}
}
