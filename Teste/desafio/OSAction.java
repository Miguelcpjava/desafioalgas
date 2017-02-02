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
	 * Pergunte a voc� mesmo, o que eu quero fazer?
	 * Separe em t�picos 
	 * Fa�a pouco a pouco testando cada parte criada
	 * Use o JUnit
	 * 
	 * Como usar o JUnit?
	 * 
	 * Sempre antes do m�todo coloque o Anota��o @Test
	 * 
	 * E o retorno tem que ser uma compara��o
	 * */
	
	
	public OrdemServico preencherOS(){
		//Instanciar o objeto
		OrdemServico os = new OrdemServico();
		//Preencher com dados
		os.setTipo("Servi�o");
		os.setDescricao("Testando o cadastro da Ordem de servi�o");
		os.setResponsavel("Marcelo");
		//Criar v�riaveis necess�rias
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
