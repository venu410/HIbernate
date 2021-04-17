package com.venu.hibernate.example.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.venu.hibernate.example.pojo.Product;

public class UpdateDataIntoDatabaseById {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sca.nextInt();
		sca.close();

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Product product = session.load(Product.class, new Integer(id));
		
		product.setProduct_Name("Laptop");
		product.setProduct_Price(product.getProduct_Price()+500.00);

		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		System.out.println(product.toString());
		session.close();
		factory.close();

	}

}
