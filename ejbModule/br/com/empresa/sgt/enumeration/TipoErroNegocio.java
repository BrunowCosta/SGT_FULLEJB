package br.com.empresa.sgt.enumeration;

public enum TipoErroNegocio implements EnumMapped {
	
	prefixoErroLogico(100,"sistema.erroPrefixo.logico"),
	prefixoErroGenerico(101,"sistema.erroPrefixo.generico"),
	funcaoNaoImplementada(200,"sistema.erro.funcaoNaoImplementada"),
	loginBLoqueado(300, "sistema.erro.login.impedido"),
	loginInvalido(301, "sistema.erro.login.invalido");
	
	private Integer codigo;
	private String descricao;
	
	TipoErroNegocio(Integer codigo, String descricao) {
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
