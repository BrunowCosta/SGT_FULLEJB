package br.com.empresa.sgt.exception;

import br.com.empresa.sgt.enumeration.MensagemEnum;

@SuppressWarnings("serial")
public class BusinessException extends Exception{
	
	private MensagemEnum erro;
	private ErroNegocioServidadeEnum severidade;
	private Exception excecaoAnterior;
	private Object[] parametros;
	
	public BusinessException(String menssagem) {
		super(menssagem);
	}
	
	public BusinessException(ErroNegocioServidadeEnum severidade, 
							 Exception excecaoAnterior,
							 MensagemEnum erro,
							 Object... params) {
		
		this.erro = erro;
		this.severidade = severidade;
		this.excecaoAnterior = excecaoAnterior;
		this.parametros = params;
	}
	
	public ErroNegocioServidadeEnum getSeveridade() {
		return severidade;
	}

	public void setSeveridade(ErroNegocioServidadeEnum severidade) {
		this.severidade = severidade;
	}

	public Exception getExcecaoAnterior() {
		return excecaoAnterior;
	}

	public void setExcecaoAnterior(Exception excecaoAnterior) {
		this.excecaoAnterior = excecaoAnterior;
	}
	
	public MensagemEnum getErro() {
		return erro;
	}

	public void setErro(MensagemEnum erro) {
		this.erro = erro;
	}
	
	public Object[] getParametros() {
		return parametros;
	}

	public void setParametros(Object[] parametros) {
		this.parametros = parametros;
	}

	public enum ErroNegocioServidadeEnum {
		ERRO, INFO, FATAL, AVISO;
		
		ErroNegocioServidadeEnum() {}

	}
	
}
