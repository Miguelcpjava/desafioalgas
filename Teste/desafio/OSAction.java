package desafio;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


import ordem.model.OrdemServico;
import ordem.negocio.OrdemServicoDAO;
import ordem.util.CodeOS;

public class OSAction {
	
	
	/*
	 * Como fazer o teste?
	 * 
	 * Pergunte a você mesmo, o que eu quero fazer?
	 * Separe em tópicos 
	 * Faça pouco a pouco testando cada parte criada
	 * Use o JUnit
	 * 
	 * Como usar o JUnit?
	 * 
	 * Sempre antes do método coloque o Anotação @Test
	 * 
	 * E o retorno tem que ser uma comparação
	 * */
	
	
	public OrdemServico preencherOS(){
		//Instanciar o objeto
		OrdemServico os = new OrdemServico();
		//Preencher com dados
		os.setTipo("Serviço");
		os.setDescricao("Testando o cadastro da Ordem de serviço");
		os.setResponsavel("Marcelo");
		//Criar váriaveis necessárias
		Date day = Calendar.getInstance().getTime();
		os.setDataOS(day);
		//os.setIdOS(new Long(1));
		return os;
	}
	
	
	public void responsavelValido(){
		OrdemServico ordem = preencherOS();
		Assert.assertEquals("Marcelo",ordem.getResponsavel());
	}
	
	
	public void salvar(){
		OrdemServicoDAO dao = new OrdemServicoDAO();
		dao.salvar(preencherOS());
	}
	
	public void salvarComID(){
		OrdemServicoDAO dao = new OrdemServicoDAO();
		Long idcapturado = dao.salvar(preencherOS());
		Assert.assertTrue(idcapturado == new Long(1));
	}
	@Test
	public void verificarCodeOS(){
		CodeOS code = new CodeOS();
		String codigoGerado = code.valorCode(code.gerarCodeAleatorio());
		System.out.println("Codigo Gerado: "+codigoGerado);
		boolean result = codigoGerado.matches("\\w");
		Assert.assertTrue(result == true);
	}
	
	
	
}
