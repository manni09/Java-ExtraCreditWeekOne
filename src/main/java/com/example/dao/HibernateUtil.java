package com.example.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.model.Project;
import com.example.model.Task;
import com.example.model.User;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {

			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Project.class);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Task.class);
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {

			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
