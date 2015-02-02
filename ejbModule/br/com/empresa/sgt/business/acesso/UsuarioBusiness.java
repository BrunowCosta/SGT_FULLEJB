package br.com.empresa.sgt.business.acesso;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.empresa.sgt.business.remote.UsuarioBusinessRemote;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.dao.UsuarioDAO;

@Stateless
@Remote(UsuarioBusinessRemote.class)
public class UsuarioBusiness extends CrudBusinessAdapter<Usuario> implements UsuarioBusinessRemote {
	
	@EJB UsuarioDAO usuarioDAO;

	@Override
	public void cadastrar(Usuario modelo, Usuario usuario) throws BusinessException {
		usuarioDAO.persist(modelo);
	}
	
	@Override
	public List<Usuario> pesquisar(Usuario modelo) throws BusinessException {
		return usuarioDAO.findByExample(modelo);
	}
	
	@Override
	public Usuario encontrar(Integer id) throws BusinessException {
		return usuarioDAO.findById(id);
	}
	
	@Override
	public void alterar(Usuario modelo, Usuario usuario) throws BusinessException {
		usuarioDAO.merge(modelo);
	}

}