package com.hibernate.first.example.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.first.example.pojo.Employee;

public class RetrieveRecords {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Employee Id");
		int emp_Id = scanner.nextInt();
		scanner.close();
		
		Employee employee = session.get(Employee.class, emp_Id);
		if(null!=employee) {
			System.out.println(employee);
		}else {
			System.out.println("No records found with "+emp_Id);
		}
		session.close();
		

	}

}
