package com.venu.hibernate.example.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.venu.hibernate.example.pojo.Product;

public class DeleteDataFromDatabase {

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

		Transaction transaction = session.beginTransaction();
		System.out.println("Product name before deletes the product:"+product.getProduct_Name());
		session.delete(product);
		
		transaction.commit();
		System.out.println("Product name After deletes the product:"+product.getProduct_Name());
		System.out.println(product.toString());
		session.close();
		factory.close();

	}

}
