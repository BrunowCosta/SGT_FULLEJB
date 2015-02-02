package br.com.empresa.sgt.model.acesso;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.empresa.sgt.enumeration.RowColorEnum;
import br.com.empresa.sgt.model.arq.Modelo;

@Entity
@Table(name="T_GRUPOPERMISSAO", schema="ACESSO")
@SequenceGenerator(name="SEQ_ID_GRUPOPERMISSAO", sequenceName="ACESSO.SEQ_ID_GRUPOPERMISSAO", schema="ACESSO", allocationSize=1)
public class GrupoPermissao implements Modelo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5023361545450577749L;

	@Id
	@Column(name="IDGRUPOPERMISSAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_GRUPOPERMISSAO")
	private Integer id;
	
	@Column(nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	private GrupoPermissaoStatusEnum status;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Permissao> permissoes;
	
	public GrupoPermissao() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GrupoPermissaoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(GrupoPermissaoStatusEnum status) {
		this.status = status;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public enum GrupoPermissaoStatusEnum implements RowColorEnum {
		ATIVO("grupoPermissao.status.ativo", "azul"),
		INATIVO("grupoPermissao.status.inativo", "cinza");
		
		private String descricao;
		private String rowColor;
		
		GrupoPermissaoStatusEnum(String descricao, String rowColor) {
			this.descricao = descricao;
			this.rowColor = rowColor;
		}

		@Override
		public String getDescricao() {
			return descricao;
		}

		@Override
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		@Override
		public String getRowColor() {
			return rowColor;
		}

		@Override
		public void setRowColor(String rowColor) {
			this.rowColor = rowColor;
		}
		
	}
	
} 
