package br.com.empresa.sgt.enumeration;

public enum PrefixoErroNegocioEnum implements EnumMapped {	
	
	ERRO_LOGICO("sistema.erroPrefixo.logico"),
	ERRO_GENERICO("sistema.erroPrefixo.generico");

	private String descricao;
	
	PrefixoErroNegocioEnum(String descricao) {
		this.descricao = descricao;
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
