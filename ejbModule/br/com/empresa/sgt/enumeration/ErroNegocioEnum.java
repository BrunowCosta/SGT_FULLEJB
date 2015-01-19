package br.com.empresa.sgt.enumeration;

public enum ErroNegocioEnum implements EnumMapped {
	
	ERRO_FUNCAO_NAO_IMPLEMENTADA(100,"erro.sistema.funcaoNaoImplementada"),
	ERRO_GENERICO(101,"erro.sistema.generico"),
	ERRO_LOGIN_BLOQUEADO(300, "erro.login.impedido"),
	ERRO_LOGIN_INVALIDO(301, "erro.login.invalido");
	
	private Integer codigo;
	private String descricao;
	
	ErroNegocioEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

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
