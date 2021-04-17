package com.hibernate.table.per.subclass.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.hbm.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		// employee.setId(1);
		employee.setName("Rahul");

		Regular_Employee employee2 = new Regular_Employee();
		employee2.setName("Venu");
		employee2.setSalary(10000);
		employee2.setBonus(1000);

		Contract_Employee employee3 = new Contract_Employee();
		employee3.setName("Kumar");
		employee3.setPay_per_hour(500);
		employee3.setContract_period("365 Days");

		session.persist(employee);
		session.persist(employee2);
		session.persist(employee3);

		transaction.commit();
		session.close();

		System.out.println("Success");

	}

}
