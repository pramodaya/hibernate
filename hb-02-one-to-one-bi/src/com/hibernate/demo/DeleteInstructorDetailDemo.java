package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("InstructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("Associated Instructor: " + tempInstructorDetail.getInstructor());

			// --------------------------------------END NEW CODE------------------------
			
			//remove the associated object reference
			//break the bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			
			// delete the instructor detail
			System.out.println("Deleting tempInstructorDetail : " + tempInstructorDetail);
			session.delete(tempInstructorDetail);

			// --------------------------------------END NEW CODE-----------
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} catch (Exception exc) {

			exc.printStackTrace();

		} finally {
			// handle connection leak issues
			session.close();

			// close the factory
			factory.close();
		}
	}

}
