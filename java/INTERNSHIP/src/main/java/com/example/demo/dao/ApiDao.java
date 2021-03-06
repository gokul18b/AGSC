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


	
	
	public List<Object[]> get_student() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from student";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}


	


	public void add_student(String name, String qualification, String mobile, String front, String back, String ps,
			String ds, String designation,String username,String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `student` (`id`, `applicantname`, `qualificatino`, `mobile`, `frontend`, `backend`, `ps`, `ds`, `designation`,`username`,`password`) VALUES "
				+ "(NULL, '"+name+"', '"+qualification+"', '"+mobile+"', '"+front+"', '"+back+"', '"+ps+"', '"+ds+"', '"+designation+"', '"+username+"', '"+password+"');";
		System.out.print("test"+sql);
		session.createSQLQuery(sql).executeUpdate();
	}

	public void add_requirement(String title, String desc, String fe, String be, String modules) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `requirement` (`id`, `title`, `description`, `frontend`, `backend`, `modules`) VALUES "
				+ "(NULL, '"+title+"', '"+desc+"', '"+fe+"', '"+be+"', '"+modules+"');";
		System.out.print("test"+sql);
		session.createSQLQuery(sql).executeUpdate();
	}




	public void add_intern(Integer pid, Integer sid) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `intern` (`id`, `pid`, `sid`, `code`) VALUES "
				+ "(NULL, "+pid+", "+sid+", '');";
		System.out.print("test"+sql);
		session.createSQLQuery(sql).executeUpdate();
			
	}
	
	public List<Object[]> get_project() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from requirement";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
			
	}

	public List<Object[]> student_getproject(Integer id) {
		// TODO Auto-generated method stub
		
		Session session = sf.getCurrentSession();
		String sql = "SELECT i.id,r.description,r.modules FROM `intern` as i LEFT JOIN student s on(s.id=i.sid) LEFT JOIN requirement r on(r.id=i.pid) WHERE s.id="+id;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	public List<Object[]> admin_getproject() {
		// TODO Auto-generated method stub
		
		Session session = sf.getCurrentSession();
		String sql = "SELECT i.id,s.applicantname,r.description,r.modules,i.code FROM `intern` as i LEFT JOIN student s on(s.id=i.sid) LEFT JOIN requirement r on(r.id=i.pid) ";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}




	public List<Object[]> view_applicant() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from student";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	public void upload_code(Integer pid, Integer sid, String code) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "UPDATE `intern` SET `code` = '"+code+"' WHERE `intern`.`id` = "+pid;
		System.out.print("test"+sql);
		session.createSQLQuery(sql).executeUpdate();
			
	}

}
