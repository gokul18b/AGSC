package com.example.demo.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ApiDao {
	@Autowired
	SessionFactory sf;




	public void citizen_register(String firstname,String lastname,String mobile,String address,String city,String state,String pincode,String username,String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `citizen` (`id`, `fname`, `lname`, `mobile`, `address`, `city`, `state`, `pincode`, `username`, `password`) VALUES "
				+ "(NULL, '"+firstname+"', '"+lastname+"', '"+mobile+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"', '"+username+"', '"+password+"');";
		session.createSQLQuery(sql).executeUpdate();
	}
	
	public void complaint_action(Integer complaint_id,String status) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "UPDATE `complaint` SET `status` = '"+status+"' WHERE `complaint`.`id` = "+complaint_id+";";
		session.createSQLQuery(sql).executeUpdate();
	}
	
	public List<Object[]> get_citizen() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from citizen";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	public List<Object[]> get_complaints() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from complaint";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	public List<Object[]> get_complaints(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from complaint where citizen_id="+id;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}


	
	public void add_complaint(Integer citizen_id,String mobile,String address,String reason) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `complaint` (`id`, `citizen_id`, `mobile`, `address`, `reason`,`status`) VALUES "
				+ "(NULL, '"+citizen_id+"', '"+mobile+"', '"+address+"', '"+reason+"', '1');";
		session.createSQLQuery(sql).executeUpdate();
	}



	public String login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";;
		NativeQuery nq = session.createNativeQuery(sql);
		if (nq.list().size() != 0) {
			return "admin";
		} else {
			String sql1 = "select * from citizen where username='"+username+"' and password='"+password+"'";;
			NativeQuery nq1 = session.createNativeQuery(sql1);
			if (nq1.list().size() != 0) {
				List<Object[]> a = nq1.list();
				return "id="+a.get(0)[0];
			}else {
				return "Invalid";
			}
		}
	}

}
