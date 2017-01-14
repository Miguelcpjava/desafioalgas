package ordem.model;

import java.util.Date;


/** Classe responsável pelo modelo de ordem de serviço
 *  Lembrando que o tipo pode ser  um serviço ou produto;
 *  Vou usar a tecnica de JPA para podemos observar das duas maneiras
 *  tanto usando xml como usando JPA. 
 * */

public class OrdemServico {

	private Long idOS;
	private Date dataOS;
	private String descricao;
	private String tipo;
	private String responsavel;
	
	
	public Long getIdOS() {
		return idOS;
	}
	public void setIdOS(Long idOS) {
		this.idOS = idOS;
	}
	public Date getDataOS() {
		return dataOS;
	}
	public void setDataOS(Date dataOS) {
		this.dataOS = dataOS;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
	
}

