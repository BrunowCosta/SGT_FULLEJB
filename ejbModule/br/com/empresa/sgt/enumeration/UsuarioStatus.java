package br.com.empresa.sgt.enumeration;

public enum UsuarioStatus implements EnumMapped{
	
	inativo(1, "usuario.inativo"),
	ativo(2, "usuario.ativo"),
	cancelado(3, "usuario.cancelado"),
	bloqueado(4, "usuario.bloqueado"),
	expirado(5, "usuario.expirado");
	
	private Integer codigo;
	private String descricao;
	
	UsuarioStatus(Integer codigo, String descricao) {
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
