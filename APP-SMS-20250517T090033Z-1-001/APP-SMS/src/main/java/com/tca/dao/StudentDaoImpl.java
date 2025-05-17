package com.tca.dao;



import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tca.entities.Student;
import com.tca.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao 
{

	@Override
	public Integer saveStudent(Student student) 
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		
		Session session=null;
		Transaction transaction=null;
			
		try
		{
			session = sf.openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(student);
			transaction.commit();
			
			return id;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
		finally
		{
			session.close();
		}
		
	}

	@Override
	public Student findStudentById(Integer id) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		
		try
		{
			session = sf.openSession();
			Student s = session.get(Student.class, id);
			return s;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			session.close();
		}
				
	}

	@Override
	public List<Student> findStudentByName(String name) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		
		try
		{
			session = sf.openSession();
			
			Query query = session.createQuery("FROM Student WHERE name LIKE '%" + name + "%'");
			List<Student> listStudent =  query.getResultList();
			return listStudent;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public List<Student> findStudentByCity(String city) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		
		try
		{
			session = sf.openSession();
			
			Query query = session.createQuery("FROM Student WHERE city LIKE '%" + city + "%'");
			List<Student> listStudent =  query.getResultList();
			return listStudent;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			session.close();
		}
	}
	
	
	@Override
	public boolean updateStudent(Student student) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =null;
		Transaction transaction = null;
		
		try
		{
			session = sf.openSession();
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
		
	}

	@Override
	public boolean deleteStudent(Student student) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		try
		{
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			session.delete(student);
			
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
		
	}

	
	
}
