package com.hibernate.first.example.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.first.example.pojo.Employee;

public class Test {

	public static void main(String[] args) {

		Employee employee = new Employee();
		//employee.setId(101);
		employee.setName("Venu");
		employee.setEmployerName("Capgemini India Pvt Ltd");
		employee.setSalary(20000);

		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		session.save(employee);

		Transaction transaction = session.beginTransaction();
		transaction.commit();

		session.close();

	}

}
