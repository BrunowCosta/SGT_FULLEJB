package br.com.empresa.sgt.enumeration;

public enum GrupoPermissaoStatus implements EnumMapped {
	
	inativo(1, "grupoPermissao.status.ativo"),
	ativo(2, "grupoPermissao.status.nativo");
	
	private Integer codigo;
	private String descricao;
	
	GrupoPermissaoStatus(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
