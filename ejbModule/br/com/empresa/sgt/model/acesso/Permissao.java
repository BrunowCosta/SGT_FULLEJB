package br.com.empresa.sgt.model.acesso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.empresa.sgt.enumeration.TipoPermissao;
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
	
	@Column(nullable=false)
	private Integer valor;
	
	@Column(nullable=false)
	private Integer tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_GRUPOPERMISSAO")
	private GrupoPermissao grupoPermissao;
	
	@Transient
	private TipoPermissao tipoPermissao;
	
	public Permissao() {}
	
	public Permissao(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public GrupoPermissao getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(GrupoPermissao grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}

	public TipoPermissao getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(TipoPermissao tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}
	
} 
