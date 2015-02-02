package br.com.empresa.sgt.enumeration;

public enum MensagemEnum implements MappedEnum {
		
	SUCESSO_OPERACAO(0000,"msg.sucesso.operacao"),
	ERRO_FUNCAO_NAO_IMPLEMENTADA(1000,"msg.erro.sistema.funcaoNaoImplementada"),
	ERRO_GENERICO(1001,"msg.erro.sistema.generico"),
	ERRO_ALTERACAO_REGISTRO_PADRAO(1002, "msg.erro.sistema.alteracaoRegistroPadrao"),
	ERRO_LOGIN_BLOQUEADO(1100, "msg.erro.login.bloqueado"),
	ERRO_LOGIN_INVALIDO(1101, "msg.erro.login.invalido");
	
	private Integer codigo;
	private String descricao;
	
	MensagemEnum(Integer codigo, String descricao) {
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
