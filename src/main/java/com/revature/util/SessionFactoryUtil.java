package com.revature.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	
	private static SessionFactory sf;
	private static SessionFactoryUtil sfu;
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "HelloYes879";
	private static final String URL = "jdbc:postgresql://feb10-2002-chris.cu70whfvvuvd.us-east-2.rds.amazonaws.com:5432/postgres?";
	private static String schema = "public";
	
	public static SessionFactoryUtil getSessionFactoryUtil() {
		if (sfu == null) {
			sfu = new SessionFactoryUtil();
		}
		return sfu;
	}
	
	private SessionFactoryUtil() {
		if (sf == null) {
			Map<String, String> settings = new HashMap<String, String>();
			settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.default_schema", schema);
			settings.put("show_sql", "true");
			settings.put("connection.pool_size", "5");
			settings.put("hibernate.connection.url", URL);
			settings.put("hibernate.connection.username", USERNAME);
			settings.put("hibernate.connection.password", PASSWORD);
			
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
			Metadata metadata = new MetadataSources(serviceRegistry)
					.addAnnotatedClass(com.revature.domains.Superhuman.class)
					.addAnnotatedClass(com.revature.domains.SuperTeam.class)
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
					.build();
			sf = metadata.getSessionFactoryBuilder().build();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sf;
	}
	
}
