package haui.vn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		//What is SessionFactory ? It is important object in HA, used to manage session with DBMS 
		try {
			return new Configuration().//Create Configuration` object holds info about way of map object from Java to DBMS
					configure().//Call `Configuration` object to load hibernate configuration from the default 
					//configuration file (usually hibernate.cfg.xml)
					buildSessionFactory();//After configuration , method build.. called to create SessionFactory object 
		}catch(Exception e) {
			System.out.println("Error can not create Session Factory!" + e);
			return null;
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}
