package com.venu.hibernate.example.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.venu.hibernate.example.pojo.Product;

public class TestHibernateConnection {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Product product = new Product(1, "iPhone", 23000.00);
		Product product1 = new Product(2, "TV", 23000.00);
		Product product2 = new Product(3, "Mobile", 23000.00);
		Product product3 = new Product(4, "Laptop", 23000.00);
		Product product4 = new Product(5, "Phone", 23000.00);


		Transaction transaction = session.beginTransaction();
		session.save(product);
		session.save(product1);
		session.save(product2);
		session.save(product3);
		session.save(product4);
		System.out.println("Product Saved Successfully with values of " + product.toString());
		transaction.commit();
		session.close();
		factory.close();

	}

}
