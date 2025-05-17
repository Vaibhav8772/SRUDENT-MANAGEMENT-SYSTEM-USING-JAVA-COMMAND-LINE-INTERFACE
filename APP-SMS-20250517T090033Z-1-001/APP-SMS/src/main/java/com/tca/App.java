package com.tca;

import java.util.List;
import java.util.Scanner;

import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

public class App 
{
    public static void main(String[] args) 
    {
       Scanner sc = new Scanner(System.in);
    	
       System.out.println("\n************** Welcome to Techno Comp Acdemy ************ \n");
       
       while(true)
       {
    	   System.out.println("Menu");
    	   System.out.println("1. Save ");
    	   System.out.println("2. Fetch By Id ");
    	   System.out.println("3. Fetch By name ");
    	   System.out.println("4. Fetch By city ");
    	   System.out.println("5. Update ");
    	   System.out.println("6. Delete ");
    	   System.out.println("7. Exit ");
    	   System.out.print("What is your choice : ");
    	   int choice = sc.nextInt();
    	   
    	   switch(choice)
    	   {
    	   		case 1 : optionSave();
    	   				 break;
    	   		case 2 : optionFetchById();
    	   				 break;
    	   		case 3 : optionFetchByName();
    	   				 break;
    	   		case 4 : optionFetchByCity();
    	   				 break;
    	   		case 5 : optionUpdate();
    	   				 break;
    	   		case 6 : optionDelete();
    	   				 break;
    	   				 
    	   		case 7 :
    	   				    	   	    	
    	   	    		System.out.println("********** Shutdown System ************* !!!");
    	   	    		HibernateUtil.closeSessionFactory();
    	   	    		System.exit(0);
    	   }
 
       }
  
    }
    
    public static void optionDelete()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter the Student ID: ");
    	int id =  sc.nextInt();
    	
    	StudentService service = StudentServiceFactory.getStudentService();
    	
    	boolean status = service.removeStudent(id);
    	
    	if(status)
    	{
    		System.out.println("Record is Deleted Succesfully for Roll Number : " + id);
    	}
    	else
    	{
    		System.out.println("Either Record is not Found or Problem during Deletion for Roll Number :" + id);
    	}
    }
    
    
    public static void optionUpdate()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter the Student ID: ");
    	int id =  sc.nextInt();
    	
    	StudentService service = StudentServiceFactory.getStudentService();
    	
    	boolean status = service.modifyStudent(id);
    	
    	if(status)
    	{
    		System.out.println("Record is Updated Succesfully for Roll Number : " + id);
    	}
    	else
    	{
    		System.out.println("Either Record is not Found or Problem during Updation  for Roll Number :" + id);
    	}
    	
    	
    }
    
    
    public static void optionFetchByCity()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter the City to Search: ");
    	String city = sc.nextLine();
    	
    	StudentService service = StudentServiceFactory.getStudentService();
    	
    	List<Student> studentList = service.fetchStudentByCity(city);
    	
    	if(studentList == null || studentList.isEmpty())
    	{
    		System.out.println("No Record found for City : " + city);
    	}
    	else
    	{
    		System.out.println("** Records Found **");
    		System.out.println("-----------------------------------------");
    		
    		for(Student student : studentList)
    		{
    		
    			System.out.println("Student Roll Number : " + student.getRno());
    			System.out.println("Student Name        : " + student.getName());
    			System.out.println("Student Percentage  : " + student.getPer());
    			System.out.println("Student City        : " + student.getCity());
    			System.out.println();
    		}
    	}
    }
    

    
    
    
    
    
    
    public static void optionFetchByName()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter the Student Name to Search: ");
    	String name = sc.nextLine();
    	
    	StudentService service = StudentServiceFactory.getStudentService();
    	
    	List<Student> studentList = service.fetchStudentByName(name);
    	
    	if(studentList == null || studentList.isEmpty())
    	{
    		System.out.println("No Record found for Name : " + name);
    	}
    	else
    	{
    		System.out.println("** Records Found **");
    		System.out.println("-----------------------------------------");
    		
    		for(Student student : studentList)
    		{
    		
    			System.out.println("Student Roll Number : " + student.getRno());
    			System.out.println("Student Name        : " + student.getName());
    			System.out.println("Student Percentage  : " + student.getPer());
    			System.out.println("Student City        : " + student.getCity());
    			System.out.println();
    		}
    	}
    }
    
    
    public static void optionFetchById()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter the Student ID: ");
    	int id =  sc.nextInt();
    	
    	StudentService service = StudentServiceFactory.getStudentService();
    	
    	Student student = service.fetchStudentById(id);
    	
    	if(student == null)
    	{
    		System.out.println("No Record found for Roll Number : " + id);
    	}
    	else
    	{
    		System.out.println("** Record Found **");
    		System.out.println("-----------------------------------------");
    		System.out.println("Student Roll Number : " + student.getRno());
    		System.out.println("Student Name        : " + student.getName());
    		System.out.println("Student Percentage  : " + student.getPer());
    		System.out.println("Student City        : " + student.getCity());
    	}
    	
    	
    	
    }
    
    
    public static void optionSave()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter Student Name : ");
    	String name = sc.nextLine();
    	
    	System.out.print("Enter Student Percentage : ");
    	double per = sc.nextDouble();
    	
    	System.out.print("Enter Student City : ");
    	String city = sc.next();
    	
    	
    	Student S = new Student();
    	S.setName(name);
    	S.setPer(Double.valueOf(per));
    	S.setCity(city);
    	    	
    	StudentService service = StudentServiceFactory.getStudentService();
    	
    	Integer id = service.addStudent(S);
    	
    	if(id==null)
    	{
    		System.out.println("Failed to Save Record !! ");
     		
    	}
    	else
    	{
    		System.out.println("Record Saved Successfully  for Roll number :" + id);
    	}
       	
    }
}
