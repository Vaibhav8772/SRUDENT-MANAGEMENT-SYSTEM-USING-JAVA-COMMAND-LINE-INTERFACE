package com.tca.factory;

import com.tca.service.StudentService;
import com.tca.service.StudentServiceImpl;

public class StudentServiceFactory 
{
	private static StudentService studentService=null;
	
	private  StudentServiceFactory() {};
	
	public static StudentService getStudentService()
	{
		if(studentService==null)
		{
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}
