package com.hibernate.table.per.subclass.annotation.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AnnotationTest {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.hbm.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setName("Rohit");

		Regular_Employee employee2 = new Regular_Employee();
		employee2.setName("Agarwal");
		employee2.setSalary(12000);
		employee2.setBonus(500);

		Contract_Employee employee3 = new Contract_Employee();
		employee3.setName("Chetan");
		employee3.setPay_per_hour(200);
		employee3.setContract_period("1 year");

		session.persist(employee);
		session.persist(employee2);
		session.persist(employee3);

		transaction.commit();
		session.close();
		
		System.out.println("Annotated class executed!!");

	}

}
