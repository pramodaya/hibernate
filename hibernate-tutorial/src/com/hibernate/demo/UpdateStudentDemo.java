package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
			int studentId = 1;
		
			session = factory.getCurrentSession();
			session.beginTransaction();
		
			//retrieve the student
			Student myStudent = session.get(Student.class, studentId);
		
			System.out.println("updating student");
			//update
			myStudent.setFirstName("Anna");
			
		
			session.getTransaction().commit();
			

			System.out.println("Done");
			
		}finally {
			//close the factory
			factory.close();
		}
	}

}
