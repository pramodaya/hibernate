package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Instructor;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
			//create the  objects
			Instructor tempInstructor = new Instructor("jonny", "depp", "jonny@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "love to code");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//note: this will also save the instructorDetail object too.
			//because CascadeType.ALL
			
			System.out.println("saving instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}finally {
			//close the factory
			factory.close();
		}
	}

}
