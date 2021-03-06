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


public String login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";;
		NativeQuery nq = session.createNativeQuery(sql);
		if (nq.list().size() != 0) {
			return "admin";
		} else {
			String sql1 = "select * from student where username='"+username+"' and password='"+password+"'";;
			NativeQuery nq1 = session.createNativeQuery(sql1);
			if (nq1.list().size() != 0) {
				List<Object[]> a = nq1.list();
				return "id="+a.get(0)[0];
			}else {
				return "Invalid";
			}
			
		}
	}


	public void studentRegister(String name, String rollno, String department, String classname, String guide,
			String mobile, String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `student` (`id`, `name`, `rollno`, `department`, `classname`, `guidename`, `mobile`, `username`, `password`) VALUES "
				+ "(NULL, '"+name+"', '"+rollno+"', '"+department+"', '"+classname+"', '"+guide+"', '"+mobile+"', '"+username+"', '"+password+"');";
		System.out.print("test"+sql);
		session.createSQLQuery(sql).executeUpdate();
	}


	public void add_project(String title, String desc, String modules, String technology) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `project` (`id`, `title`, `description`, `modules`, `technology`) VALUES "
				+ "(NULL, '	"+title+"', '"+desc+"', '"+modules+"', '"+technology+"');";
		session.createSQLQuery(sql).executeUpdate();
	}
	

	public void allocate_project(String studentid, String projectid) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `allocate` (`id`, `studentid`, `projectid`, `status`) VALUES "
				+ "(NULL, '"+studentid+"', '"+projectid	+"', 'Initiated');";
		session.createSQLQuery(sql).executeUpdate();
	}
	
	public List<Object[]> get_projects() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select s.id as student,p.id,s.name,s.rollno,p.title,p.description,a.status,p.modules,p.technology from student s left JOIN allocate a on(a.studentid=s.id) left JOIN project p ON(p.id=a.projectid)";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	
	public List<Object[]> get_student(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select s.id as student,p.id,s.name,s.rollno,p.title,p.description,a.status,p.modules,p.technology,s.guidename,a.id as allocate from student s left JOIN allocate a on(a.studentid=s.id) left JOIN project p ON(p.id=a.projectid) where s.id="+id;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_projectsA() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from project";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	public List<Object[]> get_student() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from student";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}


	public void update_project(Integer allocate_id, String status) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "UPDATE `allocate` SET `status` = '"+status+"' WHERE `allocate`.`id` = "+allocate_id;
		session.createSQLQuery(sql).executeUpdate();
	}

}
