package ordem.negocio;

import java.io.Serializable;

import ordem.model.OrdemServico;

public class OrdemServicoBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5094574410422764762L;
	/**
	 * Metodo para verificar se a descrição, tipo e o responsável da ordem está vazio
	 * @param ordem
	 * @return true or false
	 */
	protected boolean isNull(OrdemServico ordem){
		if(ordem.getDescricao().isEmpty() || ordem.getDescricao() == null
				|| ordem.getResponsavel().isEmpty() || ordem.getResponsavel() == null
				|| ordem.getTipo().isEmpty() || ordem.getTipo() == null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Método para verificar se da data foi preenchida ou não
	 * @param ordem
	 * @return msg
	 */
	protected String dataPreenchida(OrdemServico ordem){
		if(ordem.getDataOS() == null){
			return "Data deve está preenchida";
		}else{
			return "OK";
		}
	}
	
}
