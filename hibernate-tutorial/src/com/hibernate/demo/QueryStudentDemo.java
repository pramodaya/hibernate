package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
		
			//start a transaction
			session.beginTransaction();
			
			//query students
			System.out.println("all students");
			List<Student> theStudents = session.createQuery("from Student").getResultList();		
			//display students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}
					 
			
			
			//query students: last name="michel"
			System.out.println("query students: last name='michel'");
			theStudents = session.createQuery("from Student x where x.lastName='michel'").getResultList(); 
			//display students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}		
					
					
			
			//query students: lastName='michel' or firstName='rock'
			System.out.println("query students: lastName='michel' or firstName='stone'");
			
			theStudents = session.createQuery("from Student x where "
					+ "x.lastName='michel' OR x.firstName='stone'").getResultList(); 
			//display students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}				
					
			
			
			//query students where email LIKE '%@gmail.com'
			System.out.println("query students where email LIKE '%@gmail.com'");
			
			theStudents = session.createQuery("from Student x where"
					+ " x.email LIKE '%@gmail.com'").getResultList();
			//display students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}
			

	
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}finally {
			//close the factory
			factory.close();
		}
	}

}
