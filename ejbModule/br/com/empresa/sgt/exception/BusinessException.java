package br.com.empresa.sgt.exception;

import br.com.empresa.sgt.enumeration.EnumMapped;
import br.com.empresa.sgt.enumeration.ErroNegocioEnum;

@SuppressWarnings("serial")
public class BusinessException extends Exception{
	
	private ErroNegocioEnum erro;
	private ErroNegocioServidadeEnum severidade;
	private ErroNegocioPrefixoEnum prefixo;
	private Exception excecaoAnterior;
	
	public BusinessException(String menssagem) {
		super(menssagem);
	}
	
	public BusinessException(String menssagem, ErroNegocioEnum erro, 
							 ErroNegocioPrefixoEnum prefixo, ErroNegocioServidadeEnum severidade, 
							 Exception excecaoAnterior) {
		
		super(menssagem);
		this.erro = erro;
		this.prefixo = prefixo;
		this.severidade = severidade;
		this.excecaoAnterior = excecaoAnterior;
	}
	
	public ErroNegocioServidadeEnum getSeveridade() {
		return severidade;
	}

	public void setSeveridade(ErroNegocioServidadeEnum severidade) {
		this.severidade = severidade;
	}

	public ErroNegocioPrefixoEnum getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(ErroNegocioPrefixoEnum prefixo) {
		this.prefixo = prefixo;
	}

	public Exception getExcecaoAnterior() {
		return excecaoAnterior;
	}

	public void setExcecaoAnterior(Exception excecaoAnterior) {
		this.excecaoAnterior = excecaoAnterior;
	}
	
	public ErroNegocioEnum getErro() {
		return erro;
	}

	public void setErro(ErroNegocioEnum erro) {
		this.erro = erro;
	}

	public enum ErroNegocioServidadeEnum {
		ERRO, INFO, FATAL, AVISO;
		
		ErroNegocioServidadeEnum() {}

	}
	
	public enum ErroNegocioPrefixoEnum implements EnumMapped {
		GENERICO("erroPrefixo.generico"),
		LOGICO("erroPrefixo.logico");
		
		private String descricao;
		
		ErroNegocioPrefixoEnum(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
	}
	
}
