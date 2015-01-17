package br.com.empresa.sgt.business.acesso;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.empresa.sgt.business.remote.GrupoPermissaoBusinessRemote;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.GrupoPermissao;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.dao.GrupoPermissaoDAO;

@Stateless
@Remote(GrupoPermissaoBusinessRemote.class)
public class GrupoPermissaoBusiness extends CrudBusinessAdapter implements GrupoPermissaoBusinessRemote {
	
	@EJB GrupoPermissaoDAO grupoPermissaoDAO;

	@Override
	public void cadastrar(GrupoPermissao grupo, Usuario usuario) throws BusinessException {
		// TODO Validar Permissao
		grupoPermissaoDAO.persist(grupo);
	}
	
	@Override
	public List<GrupoPermissao> pesquisar(GrupoPermissao grupo, Usuario usuario) throws BusinessException {
		// TODO Validar Permissao
		return grupoPermissaoDAO.findByExample(grupo);
	}
}