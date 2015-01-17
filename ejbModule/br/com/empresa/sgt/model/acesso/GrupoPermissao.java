package br.com.empresa.sgt.model.acesso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.empresa.sgt.enumeration.GrupoPermissaoStatus;
import br.com.empresa.sgt.enumeration.TipoPermissao;

@Entity
@Table(name="T_GRUPOPERMISSAO", schema="ACESSO")
@SequenceGenerator(name="SEQ_ID_GRUPOPERMISSAO", sequenceName="ACESSO.SEQ_ID_GRUPOPERMISSAO", schema="ACESSO", allocationSize=1)
public class GrupoPermissao implements Serializable {
	
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
	
	@Column
	private int status;

	@OneToMany(cascade=CascadeType.ALL)
	private List<Permissao> permissoes;
	
	@OneToMany
	private List<Usuario> usuarios;
	
	public GrupoPermissao() {}
	
	public void init() {
		if(this.permissoes == null || this.permissoes.isEmpty()) {
			List<Permissao> permissoes = new ArrayList<Permissao>();
			for(TipoPermissao tipo : TipoPermissao.values()) {
				Permissao permissao = new Permissao();
				permissao.setTipo(tipo.getCodigo());
				permissao.setTipoPermissao(tipo);
				permissoes.add(permissao);
			}
			this.setPermissoes(permissoes);
		}
	}
	
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getStatusDescricao(){
		String descricao = "generico.outro";
		for(GrupoPermissaoStatus status : GrupoPermissaoStatus.values()) {
			if(status.getCodigo() == this.getStatus()) {
				status.getDescricao();
			}
		}
		return descricao;
	}
	
} 
