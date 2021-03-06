package ordem.negocio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ordem.model.OrdemServico;

public class OrdemServicoBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5094574410422764762L;
	/**
	 * Metodo para verificar se a descri��o, tipo e o respons�vel da ordem est� vazio
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
	 * M�todo para verificar se da data foi preenchida ou n�o
	 * @param ordem
	 * @return msg
	 */
	protected String dataPreenchida(OrdemServico ordem){
		if(ordem.getDataOS() == null){
			return "Data deve est� preenchida";
		}else{
			return "OK";
		}
	}
	
	public boolean dataMaiorOuIgualQueAtual(Date data) throws ParseException{
		Date dataAtual = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		dataAtual = (Date) formatter.parse(String.valueOf(dataAtual));
		if(data.compareTo(dataAtual) >= 0 ){
			return true;
		}else{
			return false;
		}
	}
}
