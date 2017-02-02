package desafio;

import org.junit.Assert;
import org.junit.Test;

import ordem.util.HibernateUtil;

public class BancoTeste {

	@Test
	public void conectando(){
		Assert.assertTrue(HibernateUtil.getSessionFactory().openSession().isConnected());
		
	}
}
