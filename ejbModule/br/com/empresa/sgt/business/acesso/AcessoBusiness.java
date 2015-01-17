package br.com.empresa.sgt.business.acesso;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.reference.crypto.JavaEncryptor;

import br.com.empresa.sgt.business.remote.AcessoBusinessRemote;
import br.com.empresa.sgt.enumeration.TipoErroNegocio;
import br.com.empresa.sgt.enumeration.UsuarioStatus;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.RegistroAcesso;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.arq.GenericDao;
import br.com.empresa.sgt.persistence.dao.RegistroAcessoDAO;
import br.com.empresa.sgt.persistence.dao.UsuarioDAO;

@Stateless
@Remote(AcessoBusinessRemote.class)
public class AcessoBusiness implements AcessoBusinessRemote {
	
	@EJB UsuarioDAO usuarioDAO;
	@EJB RegistroAcessoDAO registroAcessoDAO;
	
	@Override
	public Usuario autenticar(String login, String senha, RegistroAcesso registro) throws BusinessException, EncryptionException {
		
		registro.setUsuario(login);
		registro.setSenha(senha);
		registro.setDataAcesso(Calendar.getInstance());
		
		Usuario usuario = usuarioDAO.findOneByField("login", GenericDao.CONDICAO_IGUAL, login);
		// Usuário informou um login valido
		if(usuario != null) { 
			// Caso a autenticação esteja correta
			if(this.aplicaHash(senha, usuario.getSaltAgent()).equals(usuario.getSenha())) {
				if(usuario.getStatus() == UsuarioStatus.ativo.getCodigo()) {
					registro.setTipo(RegistroAcesso.TIPO_SUCESSO);
					registroAcessoDAO.persist(registro);
					return usuario;
				} else {
					// Usuario com status invalido/bloqueado
					registro.setTipo(RegistroAcesso.TIPO_BLOQUEADO);
					registroAcessoDAO.persist(registro);
					throw new BusinessException(TipoErroNegocio.loginBLoqueado.getDescricao() + 
												UsuarioStatus.ativo.getDescricao() + ".", 
												TipoErroNegocio.prefixoErroLogico.getDescricao(), 
												BusinessException.SEVERITY_ERROR, null);
				}
			}
		} 
		
		registro.setTipo(RegistroAcesso.TIPO_NEGADO);
		registroAcessoDAO.persist(registro);
		// Login ou senha invalidos
		throw new BusinessException(TipoErroNegocio.loginInvalido.getDescricao(), 
									TipoErroNegocio.prefixoErroLogico.getDescricao(), 
									BusinessException.SEVERITY_ERROR, null);
	}
	
	// TODO retirar isso daqui.
	private String aplicaHash(String senha, String saltAgent) throws EncryptionException {
		// Aplica o Hash + Salt a senha do usuário.
		JavaEncryptor enc = (JavaEncryptor) JavaEncryptor.getInstance();
		return enc.hash(senha,saltAgent);
	}

}
