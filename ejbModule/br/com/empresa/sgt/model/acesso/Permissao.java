package br.com.empresa.sgt.model.acesso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.empresa.sgt.enumeration.MappedEnum;
import br.com.empresa.sgt.model.arq.Modelo;

@Entity
@Table(name="T_PERMISSAO", schema="ACESSO")
@SequenceGenerator(name="SEQ_ID_PERMISSAO", sequenceName="ACESSO.SEQ_ID_PERMISSAO", schema="ACESSO", allocationSize=1)
public class Permissao implements Modelo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5023361545450577749L;

	@Id
	@Column(name="IDPERMISSAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PERMISSAO")
	private Integer id;
	
	@Enumerated(EnumType.ORDINAL)
	private PermissaoValorEnum valor;
	
	@Enumerated(EnumType.ORDINAL)
	private PermissaoTipoEnum tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_GRUPOPERMISSAO")
	private GrupoPermissao grupoPermissao;
	
	public Permissao() {}
	
	public Permissao(PermissaoTipoEnum tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PermissaoValorEnum getValor() {
		return valor;
	}

	public void setValor(PermissaoValorEnum valor) {
		this.valor = valor;
	}

	public PermissaoTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(PermissaoTipoEnum tipo) {
		this.tipo = tipo;
	}

	public GrupoPermissao getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(GrupoPermissao grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}
	
	public enum PermissaoValorEnum implements MappedEnum{
		NENHUMA("permissao.valor.nenhuma"),
		VISUALIZAR("permissao.valor.visualizar"),
		ALTERAR("permissao.valor.alterar");
		
		private String descricao;
		
		PermissaoValorEnum(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
	}
	
	public enum PermissaoTipoEnum implements MappedEnum{
		CONTROLE_ACESSO("permissao.controleAcesso"),
		CONTROLE_TRIBUTARIO_IPTU("permissao.controleTributario.iptu"),
		CONTROLE_TRIBUTARIO_ITBI("permissao.controleTributario.itbi"),
		CONTROLE_TRIBUTARIO_ISS("permissao.controleTributario.iss");
		
		private String descricao;
		
		PermissaoTipoEnum(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
	}

} 
