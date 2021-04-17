package com.venu.hibernate.example.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.venu.hibernate.example.pojo.Product;

public class UpdateDataIntoDatabase {

	public static void main(String[] args) {


		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Product product = new Product();
		product.setProduct_Id(2);
		product.setProduct_Price(0.00);
		

		Transaction transaction = session.beginTransaction();
		session.update(product);
		
		transaction.commit();
		System.out.println(product.toString());
		session.close();
		factory.close();

	}

}
