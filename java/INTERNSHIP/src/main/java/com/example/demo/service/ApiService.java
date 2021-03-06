package com.example.demo.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;

import com.example.demo.response.GetCitizenResponse;
import com.example.demo.response.GetComplaintResponse;
@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;


	


	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username,password);
	}

	
	
}
