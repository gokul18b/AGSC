package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ApiDao;

import com.example.demo.response.GetCitizenResponse;
import com.example.demo.response.GetComplaintResponse;
import com.example.demo.service.ApiService;


@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;
	
	@Autowired
	ApiDao dao;

	@GetMapping("/login/{username}/{password}")
	public String login(@PathVariable String username,@PathVariable String password) {
		return service.login(username,password);
	}
	
	
	@GetMapping("/add_student/{name}/{qualification}/{mobile}/{front}/{back}/{ps}/{ds}/{designation}/{username}/{password}")
	public String add_student(@PathVariable String name,@PathVariable String qualification,
			@PathVariable String  mobile,
			@PathVariable String front,
			@PathVariable String back,
			@PathVariable String ps,
			@PathVariable String ds,
			@PathVariable String designation,
			@PathVariable String username,
			@PathVariable String password) {
		dao.add_student(name,qualification,mobile,front,back,ps,ds,designation,username,password);
		return "Student Saved Sucessfully";
	}
	
	@GetMapping("/add_requirement/{title}/{desc}/{fe}/{be}/{modules}")
	public String add_requirement(@PathVariable String title,@PathVariable String desc,
			@PathVariable String  fe,
			@PathVariable String be,
			@PathVariable String modules) {
		dao.add_requirement(title,desc,fe,be,modules);
		return "Project Saved Sucessfully";
	}
	
	@GetMapping("/add_intern/{pid}/{sid}")
	public String add_intern(@PathVariable Integer pid,@PathVariable Integer sid) {
		dao.add_intern(pid,sid);
		return "Intern Saved Sucessfully";
	}
	
	
	@GetMapping("/get_student")
	public List<Object[]> get_student() {
		return dao.get_student();
		
	}
	
	@GetMapping("/get_project")
	public List<Object[]> get_project() {
		return dao.get_project();
		
	}
	
	@GetMapping("/student_getproject/{id}")
	public List<Object[]> get_project(@PathVariable Integer id) {
		return dao.student_getproject(id);
		
	}
	
	@GetMapping("/admin_getproject")
	public List<Object[]> admin_getproject() {
		return dao.admin_getproject();
		
	}
	@GetMapping("/view_applicant")
	public List<Object[]> view_applicant() {
		return dao.view_applicant();
		
	}

	@GetMapping("/upload_code/{pid}/{sid}/{code}")
	public String upload_code(@PathVariable Integer pid,@PathVariable Integer sid,@PathVariable String code) {
		dao.upload_code(pid,sid,code);
		return "Code uploaded Sucessfully";
	}
	
}
	
	
	
	

