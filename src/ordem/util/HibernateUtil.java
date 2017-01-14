package ordem.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	  private static Configuration configuration;
	    
	   static {
		   try {
				configuration = new Configuration();
				sessionFactory = configuration.configure().buildSessionFactory();
			} catch(Exception ex) {
				throw new ExceptionInInitializerError(ex);
			}
	}
	    
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    public void closeConnection(){
	        System.out.println("Fechando sessão...");
	        sessionFactory.close();
	    }
}
