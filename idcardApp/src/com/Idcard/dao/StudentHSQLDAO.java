package com.Idcard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Idcard.bean.StudentBean;


@Repository
public class StudentHSQLDAO implements StudentDAO {
	@Autowired
	SessionFactory sf;

	
	public String saveStudent(StudentBean sb) {
		System.out.println("Inside saveStudent dao");
		Session session = sf.openSession();
		System.out.println("opening session");
		Transaction tx = session.beginTransaction();
		System.out.println("begin transaction");
		session.save(sb);
		System.out.println(session.save(sb).toString());
		System.out.println("saving bean");
		tx.commit();
		System.out.println("commit");
		session.close();
		System.out.println("Inside saveStudent dao - - -end");
		return "studentsave.sucess";
	}

	
	public String deleteStudent(Long sl) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		StudentBean sb = session.get(StudentBean.class, sl);
		System.out.println("Inside delete deleting ="+sb);
		session.delete(sb);
		tx.commit();
		session.close();
		return "studentdelete.sucess";
	}

	
	public String updateStudent(StudentBean sb) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(sb);
		tx.commit();
		session.close();
		return "studentupdate.sucess";
	}

	
	public StudentBean getStudent(Long sl) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		StudentBean sb = session.get(StudentBean.class, sl);
		session.close();
		return sb;
	}

	
	public List<StudentBean> getAllStudent() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<StudentBean> studentlist = session.createQuery("from StudentBean").getResultList();
		session.close();
		return studentlist;
	}

	
	public List<StudentBean> getAllStudents(String name) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<StudentBean> studentlist = session.createQuery("from StudentBean where name=:name")
				.setParameter("name", name).getResultList();
		session.close();
		return studentlist;

	}

}
