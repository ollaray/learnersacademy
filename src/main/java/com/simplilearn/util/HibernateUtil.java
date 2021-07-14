package com.simplilearn.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(@SuppressWarnings("rawtypes") Class cls) {
		
		try {
			Configuration config = new Configuration();
			Properties settings = new Properties();
			settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost/academydb?useSSL=false");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.SHOW_SQL, true);
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			config.setProperties(settings);
			config.addAnnotatedClass(cls);
			ServiceRegistry ssr = 
					new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(ssr);
			
			return sessionFactory;
		}catch(Exception e) {
			System.out.println("There was something wrong with the connection settings "+e.getMessage());
		}
		
	return sessionFactory;	
	}
}
