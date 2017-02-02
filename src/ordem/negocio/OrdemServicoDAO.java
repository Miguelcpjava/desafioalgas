package ordem.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ordem.model.OrdemServico;
import ordem.util.HibernateUtil;

public class OrdemServicoDAO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1370892682030657762L;

	public Long salvar(OrdemServico ordemServico){
		
		        Session sessao = HibernateUtil.getSessionFactory().openSession();
		        try {
		            sessao.getTransaction().begin();
		            sessao.save(ordemServico);
		            sessao.getTransaction().commit();
		        }catch(Exception e){
		        	e.printStackTrace();
		            sessao.getTransaction().rollback();
		        } 
		        finally {
		            sessao.flush();
		            sessao.close();
		        }
		        return ordemServico.getIdOS();
		    }
	protected void atualizar(OrdemServico ordemServico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try{
			sessao.getTransaction().begin();
			sessao.update(ordemServico);
			sessao.flush();
			sessao.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			sessao.getTransaction().rollback();
		}finally{
			sessao.close();
		}
	}
	
	protected void remover(OrdemServico ordemServico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try{
			sessao.getTransaction().begin();
			sessao.delete(ordemServico);
			sessao.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			sessao.getTransaction().rollback();
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected List<OrdemServico> getOrdemServicos(){
		List<OrdemServico> OrdemServicos = null;
		 Session sessao = HibernateUtil.getSessionFactory().openSession();
		try{
			Criteria crt = sessao.createCriteria(OrdemServico.class);
			crt.addOrder(Order.asc("dataOS"));
			OrdemServicos = new ArrayList<OrdemServico>();
			OrdemServicos = crt.list();
		}catch(NoResultException ne){
			ne.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		return OrdemServicos;
	}
	
	protected OrdemServico getOrdemServicoByID(Long id) {
		System.out.println("========Pesquisando==========");
		OrdemServico OrdemServico = new OrdemServico();
		 Session sessao = HibernateUtil.getSessionFactory().openSession();
		 try{
			 Criteria crt = sessao.createCriteria(OrdemServico.class);
				crt.add(Restrictions.eq("idOS",id));
				System.out.println("=======Carregando OrdemServico====");
				OrdemServico = (OrdemServico) crt.uniqueResult();
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 sessao.close();
			 System.out.println(">>>>>>>Sessão Fechada com sucesso");
		 }
		 return OrdemServico;
	}
	
	public OrdemServico getOrdemServicoByCodeOS(String codeOS){
		OrdemServico OrdemServico =null;
		//Abro a sessão com o banco de dados
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try{
			//Crio o objeto Criteria
			Criteria cr = 
					// Nesta linha faço SELECT * FROM ORDEMSERVICO
					sessao.createCriteria(OrdemServico.class);
			//Nesta Linha adiciono a condição igual (WHERE CODEOS = ?)
			cr.add(Restrictions.eq("codeOS", codeOS));
			//Instancio a classe ordem de serviço
			OrdemServico = new OrdemServico();
			//Capturo o resultado que vem da consulta, se houver!
			OrdemServico = (OrdemServico) cr.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		return OrdemServico;
	}
}
