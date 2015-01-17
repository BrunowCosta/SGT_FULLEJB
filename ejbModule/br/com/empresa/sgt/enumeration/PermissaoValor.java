package br.com.empresa.sgt.enumeration;

public enum PermissaoValor implements EnumMapped{
	
	nenhuma(1, "permissao.valor.nenhum"),
	visualizar(2, "permissao.valor.visualizar"),
	alterar(3, "permissao.valor.alterar");
	
	private Integer codigo;
	private String descricao;
	
	PermissaoValor(Integer codigo, String descricao) {
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
