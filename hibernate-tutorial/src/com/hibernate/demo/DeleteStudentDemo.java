package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
			int studentId = 3; 
		
			session = factory.getCurrentSession();
			session.beginTransaction();
		
			//retrieve the student
			Student myStudent = session.get(Student.class, studentId);		
			
			System.out.println("deleting student");
	
			//delete the student
			session.delete(myStudent);
			
			session.getTransaction().commit();
			

			

			
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete student id=2
			
			System.out.println("delete student id=2");
			session.createQuery("delete from Student where id='2'").executeUpdate();
			
			
			session.getTransaction().commit();
			
			
			
	
			
			System.out.println("Done");
			
		}finally {
			//close the factory
			factory.close();
		}
	}

}
