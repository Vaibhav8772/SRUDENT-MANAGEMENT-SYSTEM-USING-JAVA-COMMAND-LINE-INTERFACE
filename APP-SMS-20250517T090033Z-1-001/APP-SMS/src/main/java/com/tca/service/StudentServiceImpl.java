package com.tca.service;

import java.util.List;
import java.util.Scanner;

import com.tca.dao.StudentDao;
import com.tca.entities.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService  
{

	@Override
	public Integer addStudent(Student student) 
	{
		StudentDao dao = StudentDaoFactory.getStudentDao();
		
		student.setName( student.getName().toLowerCase());  
		student.setCity( student.getCity().toLowerCase());
			
		Integer id = dao.saveStudent(student);
		return id;
	}

	@Override
	public Student fetchStudentById(Integer id) 
	{
		StudentDao  dao = StudentDaoFactory.getStudentDao();
		Student s = dao.findStudentById(id);
		
		if(s!=null)
		{
			s.setName(s.getName().toUpperCase());   // Pls make first letter of each word capital
			s.setCity(s.getCity().toUpperCase());   // Pls make first letter of each word capital
		}
		
		return s;
	}

	@Override
	public List<Student> fetchStudentByName(String name) 
	{
		StudentDao  dao = StudentDaoFactory.getStudentDao();
		List<Student> studentList = dao.findStudentByName( name.toLowerCase() );
		return studentList;
	}

	
	@Override
	public List<Student> fetchStudentByCity(String city) 
	{
		StudentDao  dao = StudentDaoFactory.getStudentDao();
		List<Student> studentList = dao.findStudentByCity( city.toLowerCase() );
		return studentList;
	}

	@Override
	public boolean modifyStudent(Integer id) 
	{
		StudentDao dao = StudentDaoFactory.getStudentDao();
		
		Student s = dao.findStudentById(id); // 7 'sachin vilas dhane' 60 Pune 
		
		if(s==null)
		{
			return false;
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.print("[ Old Name : " + s.getName() + "] Enter New Name :" );
			s.setName(sc.nextLine());
			
			System.out.print("[ Old Percentage : " + s.getPer() + "] Enter New Percentage : ");
			s.setPer(sc.nextDouble());
			
			System.out.print("[ Old City : " + s.getCity() + "] Enter New City : ");
			s.setCity(sc.next());
			
			boolean status = dao.updateStudent(s);
			return status;
			
		}
		
	}

	@Override
	public boolean removeStudent(Integer id) 
	{
		StudentDao dao = StudentDaoFactory.getStudentDao();
		Student s = dao.findStudentById(id);
		
		if(s==null)
		{
			return false;
		}
		else
		{
			boolean status = dao.deleteStudent(s);
			return status;
		}
	}
}

