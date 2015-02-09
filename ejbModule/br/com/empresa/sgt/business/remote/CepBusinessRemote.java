package br.com.empresa.sgt.business.remote;

import javax.ejb.Remote;

import org.owasp.esapi.errors.EncryptionException;

import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Endereco;

@Remote
public interface CepBusinessRemote {

	public Endereco consultarCep(String cep) throws BusinessException, EncryptionException;
	
}
