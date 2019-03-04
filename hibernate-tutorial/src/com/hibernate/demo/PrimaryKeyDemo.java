package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {	
					//create 3  student object
					System.out.println("Creating 3 student boject");
					Student tmpStudent1 = new Student("jeniffer", "lawrenc","lawrence@gmail.com");
					Student tmpStudent2 = new Student("jeff", "hardy","jeff@gmail.com");
					Student tmpStudent3 = new Student("shawn", "michel","shawn@gmail.com");
					
					//start a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the students");
					session.save(tmpStudent1);
					session.save(tmpStudent2);
					session.save(tmpStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done");
					
				}finally {
					//close the factory
					factory.close();
				}

	}


}
