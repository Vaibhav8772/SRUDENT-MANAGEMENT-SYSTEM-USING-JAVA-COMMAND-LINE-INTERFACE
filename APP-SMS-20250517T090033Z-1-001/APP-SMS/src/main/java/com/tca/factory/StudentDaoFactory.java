package com.tca.factory;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;

public class StudentDaoFactory 
{
	private static StudentDao studentDao=null;
	
	private StudentDaoFactory() {}
	
	public static StudentDao getStudentDao()
	{
		if(studentDao==null)
		{
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
		
	}
}
