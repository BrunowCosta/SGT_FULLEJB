package br.com.empresa.sgt.business.acesso;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.reference.crypto.JavaEncryptor;

import br.com.empresa.sgt.business.remote.AcessoBusinessRemote;
import br.com.empresa.sgt.enumeration.MensagemEnum;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.exception.BusinessException.ErroNegocioServidadeEnum;
import br.com.empresa.sgt.model.acesso.RegistroAcesso;
import br.com.empresa.sgt.model.acesso.RegistroAcesso.RegistroAcessoTipoEnum;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.model.acesso.Usuario.UsuarioStatusEnum;
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
		registro.setDataAcesso(Calendar.getInstance().getTime());
		
		Usuario usuario = usuarioDAO.findOneByField("login", GenericDao.CONDICAO_IGUAL, login);
		// Usuário informou um login valido
		if(usuario != null) { 
			// Caso a autenticação esteja correta
			if(this.aplicaHash(senha, usuario.getSaltAgent()).equals(usuario.getSenha())) {
				if(usuario.getStatus() == UsuarioStatusEnum.ATIVO) {
					registro.setTipo(RegistroAcessoTipoEnum.sucesso);
					registroAcessoDAO.persist(registro);
					return usuario;
				} else {
					// Usuario com status invalido/bloqueado
					registro.setTipo(RegistroAcessoTipoEnum.bloqueado);
					registroAcessoDAO.persist(registro);
					throw new BusinessException(ErroNegocioServidadeEnum.ERRO, null,
												MensagemEnum.ERRO_LOGIN_BLOQUEADO,
												usuario.getStatus());
				}
			}
		} 
		
		registro.setTipo(RegistroAcessoTipoEnum.negado);
		registroAcessoDAO.persist(registro);
		// Login ou senha invalidos
		throw new BusinessException(ErroNegocioServidadeEnum.ERRO, null, MensagemEnum.ERRO_LOGIN_INVALIDO);
	}
	
	// TODO retirar isso daqui.
	private String aplicaHash(String senha, String saltAgent) throws EncryptionException {
		// Aplica o Hash + Salt a senha do usuário.
		JavaEncryptor enc = (JavaEncryptor) JavaEncryptor.getInstance();
		return enc.hash(senha,saltAgent);
	}

}
