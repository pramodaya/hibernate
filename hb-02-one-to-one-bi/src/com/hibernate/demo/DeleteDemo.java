package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("found instructor: " + tempInstructor);

			// delete that instructor
			if (tempInstructor != null) {
				System.out.println("deleting: " + tempInstructor);
				
				//note: will also delete associated instructorDetail object too b/c of cascadeType.ALL
				session.delete(tempInstructor);
			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			// close the factory
			factory.close();
		}
	}

}
