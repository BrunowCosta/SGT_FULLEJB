package br.com.empresa.sgt.business;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.owasp.esapi.errors.EncryptionException;

import br.com.empresa.sgt.business.remote.CepBusinessRemote;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Endereco;
import br.com.empresa.sgt.persistence.dao.CepDAO;

@Stateless
public class CepBusiness implements Serializable, CepBusinessRemote {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -951136135106926739L;
	
//	@Inject CepDAO cepDAO;
	
	@Override
	public Endereco consultarCep(String cep) throws BusinessException, EncryptionException {
		return null;
	}

}
