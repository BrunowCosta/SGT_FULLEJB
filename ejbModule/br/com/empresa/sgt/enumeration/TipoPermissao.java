package br.com.empresa.sgt.enumeration;

public enum TipoPermissao implements EnumMapped {
	
	ControleAcesso(1, "permissao.controleAcesso"),
	ControleTributarioIPTU(2, "permissao.controleTributario.iptu"),
	ControleTributarioITBI(3, "permissao.controleTributario.itbi"),
	ControleTributarioISS(4, "permissao.controleTributario.iss");
	
	private Integer codigo;
	private String descricao;
	
	TipoPermissao(Integer codigo, String descricao) {
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
