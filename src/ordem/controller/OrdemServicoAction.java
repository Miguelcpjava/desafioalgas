package ordem.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import ordem.model.OrdemServico;
import ordem.negocio.OrdemServicoBO;
import ordem.negocio.OrdemServicoDAO;
import ordem.util.CodeOS;

public class OrdemServicoAction extends DispatchAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6215742980037031993L;
	public final String SUCESSO = "sucesso";
	public final String SEMSUCESSO = "failure";
	public final String IMPRIMIR = "imprimir";
	
	
	public ActionForward Sair(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			System.out.println("Página Inicial...");
		return mapping.findForward("iniciar");
	}
	
	
	public ActionForward Cadastrar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Date date =null;
		// 1ª Pega o Form
		OrdemServico ordem = (OrdemServico) form;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = (Date)formatter.parse(ordem.getDataformatada());
		ordem.setDataOS(date);
		OrdemServicoDAO dao = new OrdemServicoDAO();
		OrdemServicoBO bo = new OrdemServicoBO();
		CodeOS code = new CodeOS();
		if(bo.dataMaiorOuIgualQueAtual(ordem.getDataOS())){
			try{
				ordem.setCodeOS(code.valorCode(code.gerarCodeAleatorio()));
				//2º Salva no banco
				dao.salvar(ordem);
			}catch(Exception e){
				System.out.println("Erro ao salvar");
				e.printStackTrace();
			}
			return ImprimirOrdem(mapping, form, request, response);
		}else{
			request.setAttribute("msg", "Data escolhida é menor que data atual, escolha um data válida!");
			return mapping.findForward(SEMSUCESSO);
		}
	} 
	
	//Segundo exercicio do dia 31/01/2017
	public ActionForward ImprimirOrdem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrdemServico ordem = (OrdemServico) form;
		request.setAttribute("Ordem", ordem);
		//3º Redireciona para impressão
		return mapping.findForward(IMPRIMIR);
	}
}
