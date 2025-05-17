package com.tca.service;

import java.util.List;

import com.tca.entities.Student;

public interface StudentService 
{
	abstract public Integer addStudent(Student student);
	abstract public Student fetchStudentById(Integer id);
	abstract public List<Student> fetchStudentByName(String name);
	abstract public List<Student> fetchStudentByCity(String city);
	
	abstract public boolean modifyStudent(Integer id);
	abstract public boolean removeStudent(Integer id);
}
