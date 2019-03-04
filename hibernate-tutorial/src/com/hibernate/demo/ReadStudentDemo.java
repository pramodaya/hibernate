package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
			//create a student object
			System.out.println("Creating a new student boject");
			Student tmpStudent = new Student("Daffy", "Duck","daffy@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			System.out.println(tmpStudent);
			session.save(tmpStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//-------------------------My New Code---------------------
			
			//find out the student's id: primary key
			System.out.println("Saved Student.GeneratedID : "+ tmpStudent.getId());
								
			//1. now get a new Session and start transaction
			    
			session.beginTransaction();
			
			//2. retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+ tmpStudent.getId());
			Student myStudent = session.get(Student.class, tmpStudent.getId());
			System.out.println("Get Complete: "+ myStudent);
			
			//3. comiit the tranaction
			session.getTransaction().commit();
			

			System.out.println("Done");
			
		}finally {
			//close the factory
			factory.close();
		}
	}

}
