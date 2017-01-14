package ordem.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class teste {

	public static void main(String[] args) {
		 boolean aberto = false;
		try{
			
				AnnotationConfiguration ac = new AnnotationConfiguration();
				ac.configure();
				SchemaUpdate se = new SchemaUpdate(ac);
				se.execute(true, true);
			
	   aberto = HibernateUtil.getSessionFactory().isClosed();
		}catch(Exception e){
			e.printStackTrace();
		}
	   System.out.println("Está fechado ? "+aberto);
	}

}
