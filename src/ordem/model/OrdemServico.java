package ordem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts.action.ActionForm;


/** Classe responsável pelo modelo de ordem de serviço
 *  Lembrando que o tipo pode ser  um serviço ou produto;
 *  Vou usar a tecnica de JPA para podemos observar das duas maneiras
 *  tanto usando xml como usando JPA. 
 * */
@Entity
@Table(name="ordemservico")
public class OrdemServico extends ActionForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7016836140282172650L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long idOS;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataos",nullable=false)
	private Date dataOS;
	@Column(name="descricao",nullable=false, length=3000)
	private String descricao;
	@Column(name="tipo",nullable=false,length=150)
	private String tipo;
	@Column(name="responsavel",nullable=false,length=300)
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOS == null) ? 0 : dataOS.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idOS == null) ? 0 : idOS.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (dataOS == null) {
			if (other.dataOS != null)
				return false;
		} else if (!dataOS.equals(other.dataOS))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idOS == null) {
			if (other.idOS != null)
				return false;
		} else if (!idOS.equals(other.idOS))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	
	
	
}

