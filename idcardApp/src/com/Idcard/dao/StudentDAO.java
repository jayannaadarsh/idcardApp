package com.Idcard.dao;

import java.util.List;

import com.Idcard.bean.StudentBean;

public interface StudentDAO {

	public String saveStudent(StudentBean sb);

	public String deleteStudent(Long sl);

	public String updateStudent(StudentBean sb);

	public StudentBean getStudent(Long sl);

	public List<StudentBean> getAllStudent();

	public List<StudentBean> getAllStudents(String name);
}
