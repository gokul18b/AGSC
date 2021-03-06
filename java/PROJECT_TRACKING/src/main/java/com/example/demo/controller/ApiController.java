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
	
	
	@GetMapping("/add_student/{name}/{rollno}/{department}/{classname}/{guide}/{mobile}/{username}/{password}")
	public String member_register(@PathVariable String name,@PathVariable String rollno,
			@PathVariable String  department,
			@PathVariable String classname,
			@PathVariable String guide,
			@PathVariable String mobile,
			@PathVariable String username,
			@PathVariable String password) {
		dao.studentRegister(name,rollno,department,classname,guide,mobile,username,password);
		return "Student Saved Sucessfully";
	}
	
	@GetMapping("/add_project/{title}/{desc}/{modules}/{technology}")
	public String add_project(@PathVariable String title,@PathVariable String desc,
			@PathVariable String modules,
			@PathVariable String  technology) {
		dao.add_project(title,desc,modules,technology);
		return "Project Created ";
	}
	@GetMapping("/allocate_project/{studentid}/{projectid}")
	public String allocate_project(@PathVariable String studentid,@PathVariable String projectid) {
		dao.allocate_project(studentid,projectid);
		return "Project Allocated Completed Sucessfully";
	}
	@GetMapping("/update_status/{allocate_id}/{status}")
	public String allocate_project(@PathVariable Integer allocate_id,@PathVariable String status) {
		dao.update_project(allocate_id,status);
		return "Project Status updated Sucessfully";
	}
	
	
	@GetMapping("/get_projects")
	public List<Object[]> get_projects() {
		return dao.get_projects();
		
	}
	@GetMapping("/get_projectsA")
	public List<Object[]> get_projectsA() {
		return dao.get_projectsA();
		
	}
	@GetMapping("/get_student")
	public List<Object[]> get_student() {
		return dao.get_student();
		
	}
	@GetMapping("/get_student/{id}")
	public List<Object[]> get_student(@PathVariable Integer id) {
		return dao.get_student(id);
		
	}
	
	
	
	
	
	
	
}
