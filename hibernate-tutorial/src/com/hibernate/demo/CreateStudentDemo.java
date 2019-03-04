package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tmpStudent = new Student("stone", "cold","stone@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			session.save(tmpStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}finally {
			//close the factory
			factory.close();
		}
	}

}
