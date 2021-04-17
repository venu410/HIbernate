package com.hibernate.first.example.client;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return "Venu-" + generator();
	}

	private String generator() {
		Random random = new Random();
		int num = random.nextInt(100);
		return Integer.toString(num);
	}

}
