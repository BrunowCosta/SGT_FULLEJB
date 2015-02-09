package br.com.empresa.sgt.business.acesso;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.empresa.sgt.business.arq.CrudBusinessAdapter;
import br.com.empresa.sgt.business.remote.GrupoPermissaoBusinessRemote;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.model.acesso.GrupoPermissao;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.dao.GrupoPermissaoDAO;

@Stateless
@Remote(GrupoPermissaoBusinessRemote.class)
public class GrupoPermissaoBusiness extends CrudBusinessAdapter<GrupoPermissao> implements Serializable, GrupoPermissaoBusinessRemote {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4093925067521757188L;
	
	@Inject GrupoPermissaoDAO grupoPermissaoDAO;

	@Override
	public GrupoPermissao cadastrar(GrupoPermissao grupo, Usuario usuario) throws BusinessException {
		return grupoPermissaoDAO.persist(grupo);
	}
	
	@Override
	public List<GrupoPermissao> pesquisar(GrupoPermissao grupo) throws BusinessException {
		return grupoPermissaoDAO.findByExample(grupo);
	}
	
	@Override
	public GrupoPermissao encontrar(Integer id) throws BusinessException {
		return grupoPermissaoDAO.findById(id);
	}
	
	@Override
	public void alterar(GrupoPermissao modelo, Usuario usuario) throws BusinessException {
		grupoPermissaoDAO.merge(modelo);
	}

}