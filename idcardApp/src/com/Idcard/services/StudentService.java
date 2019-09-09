package com.Idcard.services;

import java.util.List;

import com.Idcard.bean.StudentBean;

public interface StudentService {
	
	public String createStudent(StudentBean sb);
	public String editStudent(StudentBean sb);
	public String deleteStudent(Long sl);
	public StudentBean getStudent(Long sl);
	public List<StudentBean> getAllStudents();
	public List<StudentBean> getAllStudentByName(String name);
	
	
	
	

}
