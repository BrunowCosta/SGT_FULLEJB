package br.com.empresa.sgt.business.remote;

import javax.ejb.Remote;

import org.owasp.esapi.errors.EncryptionException;

import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.RegistroAcesso;
import br.com.empresa.sgt.model.acesso.Usuario;

@Remote
public interface AcessoBusinessRemote {

	public Usuario autenticar(String login, String senha, RegistroAcesso registro) throws BusinessException, EncryptionException;
	
}
