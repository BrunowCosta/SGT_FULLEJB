package br.com.empresa.sgt.business.acesso;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.empresa.sgt.business.remote.GrupoPermissaoBusinessRemote;
import br.com.empresa.sgt.enumeration.ErroNegocioEnum;
import br.com.empresa.sgt.exception.BusinessException;
import br.com.empresa.sgt.exception.BusinessException.ErroNegocioPrefixoEnum;
import br.com.empresa.sgt.exception.BusinessException.ErroNegocioServidadeEnum;
import br.com.empresa.sgt.model.acesso.GrupoPermissao;
import br.com.empresa.sgt.model.acesso.Usuario;
import br.com.empresa.sgt.persistence.dao.GrupoPermissaoDAO;

@Stateless
@Remote(GrupoPermissaoBusinessRemote.class)
public class GrupoPermissaoBusiness extends CrudBusinessAdapter<GrupoPermissao> implements GrupoPermissaoBusinessRemote {
	
	@EJB GrupoPermissaoDAO grupoPermissaoDAO;

	@Override
	public void cadastrar(GrupoPermissao grupo, Usuario usuario) throws BusinessException {
		grupoPermissaoDAO.persist(grupo);
	}
	
	@Override
	public List<GrupoPermissao> pesquisar(GrupoPermissao grupo) throws BusinessException {
		return grupoPermissaoDAO.findByExample(grupo);
	}

}