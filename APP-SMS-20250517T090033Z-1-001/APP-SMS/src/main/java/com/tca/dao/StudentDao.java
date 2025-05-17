package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudentDao 
{
	public abstract Integer saveStudent(Student student);
	public abstract Student findStudentById(Integer id);
	public abstract List<Student> findStudentByName(String name);
	public abstract List<Student> findStudentByCity(String city);
	
	public abstract boolean updateStudent(Student student);
	public abstract boolean deleteStudent(Student student);
	
}
